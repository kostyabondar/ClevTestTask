package beans.receipt;

import beans.Commodity;
import beans.Price;
import beans.card.CardDiscount;

import java.util.List;

import static constants.Constants.DISCOUNT_PERCENT_FOR_QUANTITY;

public class ReceiptCalculator {


    public static Price getTotalOnPosition(ReceiptPosition position) {
        Commodity commodity = position.getCommodity();
        return commodity.getProduct().getPrice().mul(commodity.getUnits());
    }

    public static Price getDiscountOnPosition(ReceiptPosition position) {
        return getDiscount(getTotalOnPosition(position), DISCOUNT_PERCENT_FOR_QUANTITY);
    }

    public static Price getTotalWithDiscountOnPosition(ReceiptPosition position) {
        return new Price(getTotalOnPosition(position).sub(getDiscountOnPosition(position)));
    }

    private static Price getDiscount(Price price, int discountPercent) {
        return new Price((int) Math.ceil(price.getValue() * discountPercent) / 100);
    }

    public static Price[] getTotal(List<ReceiptPosition> receiptPositions, CardDiscount card) {

        Price taxableTotal = new Price();
        Price cardDiscount = new Price();
        Price discountCommodity = new Price();
        Price total;

        for (ReceiptPosition position :
                receiptPositions) {
            taxableTotal = new Price(taxableTotal.sum(position.getTotal()));
            discountCommodity = new Price(discountCommodity.sum(position.getDiscount()));

        }
        if (card != null) {
            cardDiscount = getDiscount(taxableTotal, card.getDiscountPercent());
        }
        total = new Price(taxableTotal).sub(cardDiscount).sub(discountCommodity);
        return new Price[]{
                taxableTotal,
                cardDiscount,
                discountCommodity,
                total
        };
    }
}
