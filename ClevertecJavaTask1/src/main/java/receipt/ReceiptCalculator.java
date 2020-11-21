package receipt;

import beans.Price;
import beans.PriceSummary;
import beans.DiscountCard;
import beans.ReceiptPosition;

import java.util.List;

public class ReceiptCalculator {

    public static Price getTotalOnPosition(Price position, int units) {
        return position.mul(units);
    }

    public static Price getDiscount(Price price, int discountPercent) {
        return price.percent(discountPercent);
    }

    public static PriceSummary getTotal(List<ReceiptPosition> receiptPositions, DiscountCard card) {
        Price taxableTotal = new Price();
        Price total = new Price();
        Price cardDiscount = new Price();

        for (ReceiptPosition position :
                receiptPositions) {
            taxableTotal = taxableTotal.sum(position.getTaxableTotal());
            total = total.sum(position.getTotal());
        }
        if (card != null) {
            cardDiscount = getDiscount(taxableTotal, card.getDiscountPercent());
        }
        total = new Price(total).sub(cardDiscount);

        return new PriceSummary(taxableTotal, cardDiscount, total);
    }
}
