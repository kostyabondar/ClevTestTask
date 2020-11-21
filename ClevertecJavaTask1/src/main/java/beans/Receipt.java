package beans;

import java.util.ArrayList;

public class Receipt {


    private ArrayList<ReceiptPosition> receiptPositions;
    private PriceSummary priceSummary;
    private DiscountCard discountCard;


    public Receipt(ArrayList<ReceiptPosition> receiptPositions, PriceSummary priceSummary, DiscountCard discountCard) {
        this.receiptPositions = receiptPositions;
        this.priceSummary = priceSummary;
        this.discountCard = discountCard;
    }

    public Price getTaxableTotal() {
        return this.priceSummary.getTaxableTotal();
    }

    public Price getTotalDiscount() {
        return this.priceSummary.getTaxableTotal().sub(this.priceSummary.getTotal());
    }

    public Price getCardDiscount() {
        return this.priceSummary.getCardDiscount();
    }

    public Price getTotal() {
        return this.priceSummary.getTotal();
    }

    public ArrayList<ReceiptPosition> getReceiptPositions() {
        return receiptPositions;
    }

    public DiscountCard getDiscountCard() {
        return this.discountCard;
    }
}
