package beans.factory;

import beans.Commodity;
import beans.receipt.DiscountReceiptPosition;
import beans.receipt.ReceiptPosition;
import constants.Constants;

public class ReceiptPositionFactory {

    public static ReceiptPosition getReceiptPositionClassFromFactory(Commodity commodity, int quantity) {

        if (quantity > Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THAN) {
            return new DiscountReceiptPosition(commodity);
        }
        else return new ReceiptPosition(commodity);
    }
}
