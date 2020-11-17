package beans;

import factory.CommodityFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static constants.Constants.*;

public class CommodityList {

    private List<Commodity> commoditiesList = new ArrayList<>();
    private List<Product> products;
    private int cardNumber;
    private boolean cardChecker;
    private int cardDiscount;

    public CommodityList(String[] args) {
        this.products = ProductList.getInstance();
        for (int i = 0; i < args.length; i++) {
            String[] line = args[i].split(DELIMITER_ARGS);
            if (!("card".equals(line[0]))) {
                int itemId = Integer.parseInt(line[0]);
                int quantity = Integer.parseInt(line[1]);

                for (Product product :
                        products) {
                    if (product.getId() == itemId) {
//                        System.out.println(product);
                        commoditiesList.add(CommodityFactory.getCommodityClassFromFactory(product, quantity));
                    } else {
//                        ToDo System.out.println("not found Exception");
                    }
                }

            } else {
                this.cardNumber = Integer.parseInt(line[1]);
                cardChecker = true;
                cardDiscount = CARD_DISCOUNT_PERCENT;
            }
        }
    }


    public List<Commodity> getCommoditiesList() {
        return commoditiesList;
    }

    public void setCommoditiesList(List<Commodity> commoditiesList) {
        this.commoditiesList = commoditiesList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isCardChecker() {
        return cardChecker;
    }

    public void setCardChecker(boolean cardChecker) {
        this.cardChecker = cardChecker;
    }

    public int getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(int cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    public Price[] calcTotal() {
        Price taxableTotal = new Price();
        Price cardDiscount = new Price();
        Price discountCommodity = new Price();
        Price total = new Price();

        for (Commodity commodity :
                commoditiesList) {
            taxableTotal = new Price(taxableTotal.sum(commodity.getTaxableTotalPriceCommodity()));
            if (commodity instanceof DiscountCommodity) {
                discountCommodity = new Price(discountCommodity.sum(((DiscountCommodity) commodity).getAmountDiscount()));
            }
        }
        if (cardChecker) {
            cardDiscount = taxableTotal.amountDiscount(this.cardDiscount);
        }
        total = new Price(taxableTotal).minus(cardDiscount).minus(discountCommodity);
        return new Price[]{
                taxableTotal,
                cardDiscount,
                discountCommodity,
                total
        };
    }

    private void getFooterCheck(Price[] totals) {
        final String DISCOUNT_CARD_AND_PERCENT = DISCOUNT_CARD_NUMBER + cardNumber + "(" + cardDiscount + "%) ";
        String[] titlesForFooter = {
                TAXABLE_TOT,
                DISCOUNT_CARD_AND_PERCENT,
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

    //    где расположить метод вывода чека, либо создается отдельный класс
    public void printCheck() {
        //header

        Date date = new Date();
        System.out.printf("%45s\t%3$td/%3$tm/%3$tY%n%45s\t%3$tH:%3$tM:%3$tS" +
                "%n----------------------------------------------------------" +
                "%n", "DATE:", "TIME:", date);
        System.out.printf(FORMAT_FOR_BODY, "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        for (Commodity commodity : commoditiesList) {
            System.out.printf(FORMAT_FOR_BODY, commodity.getUnits(), commodity.getProduct().getName(), commodity.getProduct().getPrice(), commodity.getTaxableTotalPriceCommodity());
            if (commodity instanceof DiscountCommodity) {
//                System.out.printf("%35s -%s%n", "DISCOUNT " + DiscountCommodity.getPercentDiscount() + "%", ((DiscountCommodity) commodity).getAmountDiscount());
                System.out.printf(FORMAT_FOR_BODY, "", "discount", "", ((DiscountCommodity) commodity).getAmountDiscount().mul(-1));
                System.out.printf(FORMAT_FOR_BODY, "", "total", "", commodity.getTotalPriceCommodity());
            }
        }
        System.out.println(HORIZONTAL_LINE);

        getFooterCheck(calcTotal());

//        System.out.printf(
//                "%-40s %17s%n",
//                "TAXABLE TOT",
//                calcTotal()[0]
//        );
//        System.out.printf(
//                "%-40s %17s%n",
//                "Discount card number " + cardNumber + "(" + cardDiscount + "%) ",
//                calcTotal()[1]
//        );
//        System.out.printf(
//                "%-40s %17s%n",
//                "discount " + DiscountCommodity.getPercentDiscount() + "% if quantity more then " + Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THEN,
//                calcTotal()[2]
//        );
//        System.out.printf(
//                "%-40s %17s%n",
//                "TOTAL",
//                calcTotal()[3]
//        );


//        StringBuilder builder = new StringBuilder();
//        builder.append("%45s\t%3$td/%3$tm/%3$tY%n%45s\t%3$tH:%3$tM:%3$tS");
//        Formatter formatter = new Formatter(builder);
//        System.out.print(formatter);
    }

    @Override
    public String toString() {
        return "CommodityList{" +
                "commoditiesList=" + commoditiesList +
                ", cardNumber=" + cardNumber +
                ", cardChecker=" + cardChecker +
                ", cardDiscount=" + cardDiscount +
                '}' + "\n\nTOTAL = ";
    }
}
