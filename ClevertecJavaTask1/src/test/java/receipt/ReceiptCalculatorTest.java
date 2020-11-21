package receipt;

import beans.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptCalculatorTest {

    private static final Price PRICE_FOR_TEST = new Price(1000);

    @Test
    public void getTotalOnPosition() {
        Price actual = ReceiptCalculator.getTotalOnPosition(PRICE_FOR_TEST, 10);
        Price expected = new Price(10000);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void getDiscount() {
        Price actual = ReceiptCalculator.getDiscount(PRICE_FOR_TEST, 10);
        Price expected = new Price(100);
        assertTrue(actual.equals(expected));
    }
}