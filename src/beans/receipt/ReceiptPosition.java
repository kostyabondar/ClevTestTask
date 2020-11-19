package beans.receipt;

import beans.Commodity;
import beans.Price;

import static constants.Constants.DELIMITER;

public class ReceiptPosition {

    private Commodity commodity;
    private Price total;

    public ReceiptPosition(Commodity commodity) {
        this.commodity = commodity;
        this.total = getTotalOnPosition();
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

    private Price getTotalOnPosition() {
        return ReceiptCalculator.getTotalOnPosition(this);
    }

    @Override
    public String toString() {
        return "ReceiptPosition{}" + commodity + DELIMITER + total ;
    }
}
