package beans.receipt;

import beans.Commodity;
import beans.Price;

public class DiscountReceiptPosition extends ReceiptPosition {

    private Price discount;
    private Price totalWithDiscount;


    public DiscountReceiptPosition(Commodity commodity) {
        super(commodity);
        this.discount = getDiscountOnPosition();
        this.totalWithDiscount = getTotalWithDiscountOnPosition();
    }

    public Price getDiscount() {
        return discount;
    }

    public void setDiscount(Price discount) {
        this.discount = discount;
    }

    public Price getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public void setTotalWithDiscount(Price totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }

    private Price getDiscountOnPosition() {
        return ReceiptCalculator.getDiscountOnPosition(this);
    }

    private Price getTotalWithDiscountOnPosition() {
        return ReceiptCalculator.getTotalWithDiscountOnPosition(this);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + discount + " = " + totalWithDiscount;
    }
}
