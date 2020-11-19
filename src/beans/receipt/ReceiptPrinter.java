package beans.receipt;

import beans.Commodity;
import beans.Price;
import beans.card.CardDiscount;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import static constants.Constants.*;

public class ReceiptPrinter {

    private static StringBuilder builder = new StringBuilder();

    public static void printReceiptToConsoleAndSaveInFile(Receipt receipt) {
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

    private static void getHeader() {
        Date date = new Date();
        Formatter formatter = new Formatter();
        dividingLine(UP_AND_DOWN);
        builder.append(formatter.format("%n%45s\t%3$td/%3$tm/%3$tY%n%45s\t%3$tH:%3$tM:%3$tS%n", "DATE:", "TIME:", date));
    }

    private static void getBody(Receipt receipt) {
        dividingLine(PART_SEPARATOR);
        printRow("QTY", "DESCRIPTION", "PRICE", "TOTAL");
        ArrayList<ReceiptPosition> receiptPositions = receipt.getReceiptPositions();
        for (ReceiptPosition receiptPosition : receiptPositions) {
            Commodity commodity = receiptPosition.getCommodity();
            int quantity = commodity.getUnits();
            String description = commodity.getProduct().getName();
            Price price = commodity.getProduct().getPrice();
            Price totalPrice = receiptPosition.getTotal();
            printRow(String.valueOf(quantity), description, price.toString(), totalPrice.toString());
            if (quantity > QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THAN) {
                printRow("", "", "disc.", ((DiscountReceiptPosition) receiptPosition).getDiscount().mul(-1).toString());
                printRow("", "", "tot.", ((DiscountReceiptPosition) receiptPosition).getTotalWithDiscount().toString());
            }
            dividingLine(RECEIPT_POSITION_SEPARATOR);
        }
        dividingLine(PART_SEPARATOR);
    }

    private static void dividingLine(char delimiter) {
        for (int i = 0; i < DIVIDING_LINE_LENGTH; i++) {
            builder.append(delimiter);
        }
        builder.append("\n");
    }

    private static void printRow(String qtyRow, String descriptionRow, String priceRow, String totalRow) {
        Formatter formatter = new Formatter();
        builder.append(formatter.format(FORMAT_FOR_BODY, qtyRow, descriptionRow, priceRow, totalRow));
    }

    private static void getFooter(Receipt receipt) {

        Price[] totals = {
                receipt.getTaxableTotal(),
                receipt.getTotalDiscount(),
                receipt.getDiscountCard(),
                receipt.getTotal()
        };
        CardDiscount cardDiscount = receipt.getCardDiscount();
        String discountCardAndPercent;
        if (cardDiscount == null) {
            discountCardAndPercent = NO_CARD_DISCOUNT;
        } else {
            discountCardAndPercent = DISCOUNT_CARD_NUMBER + cardDiscount.getCardNumber() + "(" + cardDiscount.getDiscountPercent() + "%) ";
        }
        String[] titlesForFooter = {
                TAXABLE_TOT,
                discountCardAndPercent,
                DISCOUNT_PERCENT_AND_QUANTITY,
                TOTAL
        };

        for (int i = 0; i < totals.length; i++) {
            Formatter formatter = new Formatter();
            builder.append(formatter.format(
                    FORMAT_FOR_FOOTER,
                    titlesForFooter[i],
                    totals[i]
            ));
        }
        dividingLine(UP_AND_DOWN);
        builder.append("END\n");
    }
}
