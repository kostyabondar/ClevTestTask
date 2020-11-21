package beans;

import org.junit.Test;
import receipt.ReceiptCalculator;

import static org.junit.Assert.*;

public class PriceTest {

    private static final Price PRICE = new Price(1000);

    @Test
    public void mul() {
        Price actual = PRICE.mul(10);
        Price expected = new Price(10000);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void percent() {
        Price actual = PRICE.percent(10);
        Price expected = new Price(100);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void sum() {
        Price actual = PRICE.sum(new Price(1020));
        Price expected = new Price(2020);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void sub() {
        Price actual = PRICE.sub(new Price(334));
        Price expected = new Price(666);
        assertTrue(actual.equals(expected));
    }
}