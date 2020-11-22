package beans;

public class PriceSummary {
    private Price taxableTotal;
    private Price cardDiscount;
    private Price total;

    public PriceSummary(Price taxableTotal, Price cardDiscount, Price total) {
        this.taxableTotal = taxableTotal;
        this.cardDiscount = cardDiscount;
        this.total = total;
    }

    public Price getTaxableTotal() {
        return taxableTotal;
    }

    public void setTaxableTotal(Price taxableTotal) {
        this.taxableTotal = taxableTotal;
    }

    public Price getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(Price cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    public Price getTotal() {
        return total;
    }

    public void setTotal(Price total) {
        this.total = total;
    }
}
