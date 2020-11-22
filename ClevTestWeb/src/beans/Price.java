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

    public int getDollars() {
        return value / 100;
    }

    public int getCents() {
        return value % 100;
    }

    public Price mul(int value) {
        return new Price(this.value * value);
    }

    public Price percent(int percent) {
        return new Price((int) Math.floor(this.value * percent) / 100);
    }

    public Price sum(Price price) {
        return new Price(this.value + price.value);
    }

    public Price sub(Price price) {
        return new Price(this.value - price.value);
    }

    @Override
    public String toString() {
        int cents = getCents();
        return getDollars() + "." + Math.abs(cents / 10) + Math.abs(cents % 10) + "$";
    }
}
