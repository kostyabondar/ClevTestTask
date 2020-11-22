package beans;

import receipt.ReceiptCalculator;

import static constants.Constants.DELIMITER;

public class ReceiptPosition {

    private Commodity commodity;
    private Price total;

    public ReceiptPosition(Commodity commodity) {
        this.commodity = commodity;
        this.total = ReceiptCalculator.getTotalOnPosition(commodity.getProduct().getPrice(), commodity.getUnits());
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

    public Price getTaxableTotal() {
        return total;
    }

    public void setTotal(Price total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReceiptPosition{}" + commodity + DELIMITER + total;
    }
}
