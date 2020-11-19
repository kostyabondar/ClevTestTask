package beans.receipt;

import beans.Price;
import beans.card.CardDiscount;

import java.util.ArrayList;

public class Receipt {


    private ArrayList<ReceiptPosition> receiptPositions;
    private Price taxableTotal;
    private Price totalDiscount;
    private Price discountCard;
    private Price total;
    private CardDiscount cardDiscount;


    public Receipt(ArrayList<ReceiptPosition> receiptPositions, Price taxableTotal, Price totalDiscount, Price discountCard, Price total, CardDiscount cardDiscount) {
        this.receiptPositions = receiptPositions;
        this.taxableTotal = taxableTotal;
        this.totalDiscount = totalDiscount;
        this.discountCard = discountCard;
        this.total = total;
        this.cardDiscount = cardDiscount;
    }

    public Price getTaxableTotal() {
        return taxableTotal;
    }

    public void setTaxableTotal(Price taxableTotal) {
        this.taxableTotal = taxableTotal;
    }

    public Price getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Price totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Price getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(Price discountCard) {
        this.discountCard = discountCard;
    }

    public Price getTotal() {
        return total;
    }

    public void setTotal(Price total) {
        this.total = total;
    }


    public ArrayList<ReceiptPosition> getReceiptPositions() {
        return receiptPositions;
    }

    public void setReceiptPositions(ArrayList<ReceiptPosition> receiptPositions) {
        this.receiptPositions = receiptPositions;
    }

    public CardDiscount getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(CardDiscount cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

}
