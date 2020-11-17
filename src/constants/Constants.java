package constants;

import beans.DiscountCommodity;

public class Constants {

    public static final int QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THEN = 5;
    public static final int CARD_DISCOUNT_PERCENT= 50;

    public static final String TAXABLE_TOT = "TAXABLE TOT";
    public static final String TOTAL = "TOTAL";
    public static final String DISCOUNT_CARD_NUMBER = "Discount card number ";

    public static final String DISCOUNT_PERCENT_AND_QUANTITY = "discount " + DiscountCommodity.getPercentDiscount() + "% if quantity more then " + Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THEN;
    public static final String FORMAT_FOR_FOOTER = "%-40s %17s%n";
    public static final String FORMAT_FOR_BODY = "%-5s %-20s %15s %15s%n";
    public static final String HORIZONTAL_LINE = "==========================================================";
    public static final String DELIMITER_ARGS = "-";
}
