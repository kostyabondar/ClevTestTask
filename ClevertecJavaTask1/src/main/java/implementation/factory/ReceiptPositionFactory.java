package implementation.factory;

import beans.Commodity;
import beans.DiscountReceiptPosition;
import beans.ReceiptPosition;
import constants.Constants;

public class ReceiptPositionFactory {

    public static ReceiptPosition getReceiptPositionClassFromFactory(Commodity commodity, int quantity) {

        if (quantity > Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THAN) {
            return new DiscountReceiptPosition(commodity);
        }
        else return new ReceiptPosition(commodity);
    }
}
