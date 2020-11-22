package beans;

public class DiscountCard {
    private String cardNumber;
    private int discountPercent;

    public DiscountCard(String cardNumber, int discountPercent) {
        this.cardNumber = cardNumber;
        this.discountPercent = discountPercent;
    }

    public DiscountCard(String cardNumber) {
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
        return "DiscountCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
