package beans.receipt;

import beans.Commodity;
import beans.Price;

import static constants.Constants.DELIMITER;

public class ReceiptPosition {

    private Commodity commodity;
    private Price total;
    private Price discount;
    private Price totalWithDiscount;

    public ReceiptPosition(Commodity commodity) {
        this.commodity = commodity;
        this.total = getTotalOnPosition();
        this.discount = getDiscountOnPosition();
        this.totalWithDiscount = getTotalWithDiscountOnPosition();
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Price getTotal() {
        return total;
    }

    public void setTotal(Price total) {
        this.total = total;
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

    private Price getTotalOnPosition() {
        return ReceiptCalculator.getTotalOnPosition(this);
    }

    private Price getDiscountOnPosition() {
        return ReceiptCalculator.getDiscountOnPosition(this);
    }

    private Price getTotalWithDiscountOnPosition() {
        return ReceiptCalculator.getTotalWithDiscountOnPosition(this);
    }

    @Override
    public String toString() {
        return "ReceiptPosition{}" + commodity + DELIMITER + total + " - " + discount + " = " + totalWithDiscount;
    }
}
