package receipt;

import beans.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import static constants.Constants.*;

public class ReceiptPrinter {

    private StringBuilder builder = new StringBuilder();

    public StringBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public void printReceiptToConsoleAndSaveInFile(Receipt receipt) {
        getHeader();
        getBody(receipt);
        getFooter(receipt);
        try {
            FileWriter writer = new FileWriter(PATH_PRINTED_RECEIPT, true);
            writer.write(String.valueOf(builder));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
    }

    private void getHeader() {
        Date date = new Date();
        Formatter formatter = new Formatter();
        dividingLine(UP_AND_DOWN);
        builder.append(formatter.format("%n%45s\t%3$td/%3$tm/%3$tY%n%45s\t%3$tH:%3$tM:%3$tS%n", "DATE:", "TIME:", date));
    }


    private void getBody(Receipt receipt) {
        dividingLine(PART_SEPARATOR);
        printRow("QTY", "DESCRIPTION", "PRICE", "TOTAL");
        ArrayList<ReceiptPosition> receiptPositions = receipt.getReceiptPositions();
        for (ReceiptPosition receiptPosition : receiptPositions) {
            Commodity commodity = receiptPosition.getCommodity();
            int quantity = commodity.getUnits();
            String description = commodity.getProduct().getName();
            Price price = commodity.getProduct().getPrice();
            Price taxableTotal = receiptPosition.getTaxableTotal();
            printRow(String.valueOf(quantity), description, price.toString(), taxableTotal.toString());
            if (receiptPosition instanceof DiscountReceiptPosition) {
                DiscountReceiptPosition discountReceiptPosition = (DiscountReceiptPosition) receiptPosition;
                printRow("",
                        "!!!DISCOUNT!!!",
                        "-" + DISCOUNT_PERCENT_FOR_QUANTITY + "%",
                        discountReceiptPosition.getDiscount().mul(-1).toString());
                printRow("",
                        "",
                        "tot.",
                        discountReceiptPosition.getTotal().toString());
            }
            dividingLine(RECEIPT_POSITION_SEPARATOR);
        }
        dividingLine(PART_SEPARATOR);
    }

    private void dividingLine(char delimiter) {
        for (int i = 0; i < DIVIDING_LINE_LENGTH; i++) {
            builder.append(delimiter);
        }
        builder.append("\n");
    }

    private void printRow(String qtyRow, String descriptionRow, String priceRow, String totalRow) {
        Formatter formatter = new Formatter();
        builder.append(formatter.format(FORMAT_FOR_BODY, qtyRow, descriptionRow, priceRow, totalRow));
    }

    private void getFooter(Receipt receipt) {

        DiscountCard discountCard = receipt.getDiscountCard();
        String discountCardAndPercent;
        if (discountCard == null) {
            discountCardAndPercent = NO_CARD_DISCOUNT;
        } else {
            discountCardAndPercent = DISCOUNT_CARD_NUMBER + discountCard.getCardNumber() + "(" + discountCard.getDiscountPercent() + "%) ";
        }

        builder.append(new Formatter().format(
                FORMAT_FOR_FOOTER,
                TAXABLE_TOT,
                receipt.getTaxableTotal()));
        builder.append(new Formatter().format(
                FORMAT_FOR_FOOTER,
                discountCardAndPercent,
                receipt.getCardDiscount().mul(-1)));
        builder.append(new Formatter().format(
                FORMAT_FOR_FOOTER,
                TOTAL_DISCOUNT,
                receipt.getTotalDiscount().mul(-1)));
        builder.append(new Formatter().format(
                FORMAT_FOR_FOOTER,
                TOTAL,
                receipt.getTotal()));

        dividingLine(UP_AND_DOWN);
        builder.append("END\n");
    }
}
