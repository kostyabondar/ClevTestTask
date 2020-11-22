package beans;

import receipt.ReceiptCalculator;

import static constants.Constants.DISCOUNT_PERCENT_FOR_QUANTITY;

public class DiscountReceiptPosition extends ReceiptPosition {

    public DiscountReceiptPosition(Commodity commodity) {
        super(commodity);
    }

    public Price getDiscount() {
        return ReceiptCalculator.getDiscount(super.getTotal(), DISCOUNT_PERCENT_FOR_QUANTITY);
    }

    public Price getTotal() {
        return super.getTotal().sub(getDiscount());
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getDiscount() + " = " + getTotal();
    }
}
