package beans;

public class DiscountCommodity extends Commodity {
    // где расположить константу процента скидки
    private static final int PERCENT_DISCOUNT = 10;
    private Price amountDiscount;
    public DiscountCommodity(Product product, int units) {
        super(product, units);
        this.amountDiscount = super.getTotalPriceCommodity().amountDiscount(PERCENT_DISCOUNT);
    }

    public DiscountCommodity(Commodity commodity) {
        super(commodity.getProduct(), commodity.getUnits());

    }

    public static int getPercentDiscount() {
        return PERCENT_DISCOUNT;
    }

    public Price getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(Price amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    @Override
    public Price getTotalPriceCommodity() {
        return new Price(super.getTotalPriceCommodity().priceWithDiscount(PERCENT_DISCOUNT));
//        return new Price(super.getTotalPriceCommodity().minus(amountDiscount));
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + PERCENT_DISCOUNT;
    }
}
