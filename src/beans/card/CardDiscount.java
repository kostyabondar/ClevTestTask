package beans.card;

import java.util.Objects;

public class CardDiscount {
    private String cardNumber;
    private int discountPercent;

    public CardDiscount() {
        this("", 0);
    }

    public CardDiscount(String cardNumber, int discountPercent) {
        this.cardNumber = cardNumber;
        this.discountPercent = discountPercent;
    }

    public CardDiscount(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "CardDiscount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDiscount that = (CardDiscount) o;
        return cardNumber.equals(that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, discountPercent);
    }
}
