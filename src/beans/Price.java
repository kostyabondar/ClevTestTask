package beans;

public class Price {

    private int value;

    public Price() {
        this.value = 0;
    }

    public Price(int value) {
        this.value = value;
    }

    public Price(Price price) {
        this(price.value);
    }

    public Price(int dollars, int cents) {
        this.value = dollars * 100 + cents;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDollars() {
        return value / 100;
    }

    public int getCents() {
        return value % 100;
    }

    public Price mul(int value) {
        return new Price(this.value * value);
    }

    public Price amountDiscount(int value) {
        return new Price((int) Math.ceil((this.value * value) / 100));
    }

    public Price priceWithDiscount(int value) {
        return this.minus(amountDiscount(value));
    }

    public Price sum(Price price) {
        return new Price(this.value + price.value);
    }

    public Price minus(Price price) {
        return new Price(this.value - price.value);
    }

    public Price result(Price total, Price personalDiscountTotal) {

        return new Price(total.minus(personalDiscountTotal));
    }

    @Override
    public String toString() {
        int cents = getCents();
        return getDollars() + "." + Math.abs(cents / 10) + Math.abs(cents % 10) + "$";
    }
}
