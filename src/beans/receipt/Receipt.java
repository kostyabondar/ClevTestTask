package beans.receipt;

import beans.Commodity;
import beans.Price;
import beans.Product.Product;
import beans.Product.ProductListFromMemory;
import beans.card.CardDiscount;
import beans.card.CardListFromMemory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static constants.Constants.*;

public class Receipt {


    private ArrayList<ReceiptPosition> receiptPositions;

    private CardDiscount cardDiscount;

    public Receipt(String[] args) {
        parseArgsToListReceiptPosition(args);
    }

    public ArrayList<ReceiptPosition> getReceiptPositions() {
        return receiptPositions;
    }

    public void setReceiptPositions(ArrayList<ReceiptPosition> receiptPositions) {
        this.receiptPositions = receiptPositions;
    }

    public CardDiscount getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(CardDiscount cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    public void getHeader() {
        System.out.println("\n\n\n");
        Date date = new Date();
        System.out.printf("%45s\t%3$td/%3$tm/%3$tY%n%45s\t%3$tH:%3$tM:%3$tS" +
                "%n----------------------------------------------------------" +
                "%n", "DATE:", "TIME:", date);
    }

    public void getBody() {
        System.out.printf(FORMAT_FOR_BODY, "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        for (ReceiptPosition receiptPosition : receiptPositions) {
            System.out.printf(FORMAT_FOR_BODY, receiptPosition.getCommodity().getUnits(), receiptPosition.getCommodity().getProduct().getName(), receiptPosition.getCommodity().getProduct().getPrice(), receiptPosition.getTotal());
            if (receiptPosition.getCommodity().getUnits() > QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THAN) {
//                System.out.printf("%35s -%s%n", "DISCOUNT " + DiscountCommodity.getPercentDiscount() + "%", ((DiscountCommodity) receiptPosition).getAmountDiscount());
                System.out.printf(FORMAT_FOR_BODY, "", "discount", "", receiptPosition.getDiscount().mul(-1));
                System.out.printf(FORMAT_FOR_BODY, "", "total with discount", "", receiptPosition.getTotalWithDiscount());
            }
        }
        System.out.println(HORIZONTAL_LINE);
    }

    public void getFooter(Price[] totals) {


        String discountCardAndPercent = "";
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
            System.out.printf(
                    FORMAT_FOR_FOOTER,
                    titlesForFooter[i],
                    totals[i]
            );
        }
        System.out.println(HORIZONTAL_LINE);
    }


    public List<ReceiptPosition> parseArgsToListReceiptPosition(String[] args) {

        ProductListFromMemory fromMemory = new ProductListFromMemory();
        List<Product> products = fromMemory.getProductList();
        receiptPositions = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String[] line = args[i].split(DELIMITER_ARGS);
            if (!("card".equals(line[0]))) {
                int itemId = Integer.parseInt(line[0]);
                int quantity = Integer.parseInt(line[1]);

                for (Product product :
                        products) {
                    if (product.getId() == itemId) {
//                        System.out.println(product);
                        receiptPositions.add(new ReceiptPosition(new Commodity(product, quantity)));
                    } else {
//                        ToDo System.out.println("not found Exception");
                    }
                }

            } else {
                CardListFromMemory cardListFromMemory = new CardListFromMemory();
                List<CardDiscount> cardDiscountList = cardListFromMemory.getCardDiscountsList();
                CardDiscount presentedCardDiscount = new CardDiscount(line[1]);
                if (cardDiscountList.contains(presentedCardDiscount)) {
                    for (CardDiscount cardDiscount :
                            cardDiscountList) {
                        this.cardDiscount = cardDiscount.equals(presentedCardDiscount) ? cardDiscount : cardDiscount;
                    }
                } else {
                    cardDiscount = null;
                }


            }
        }
        return receiptPositions;
    }

    public void getReceipt() {
        getHeader();
        getBody();
        getFooter(ReceiptCalculator.getTotal(receiptPositions, cardDiscount));
    }
}
