package beans.receipt;

import beans.Commodity;
import beans.Price;
import beans.card.CardDiscount;
import beans.factory.ReceiptPositionFactory;
import beans.interfaces.ICardStore;
import beans.interfaces.IProductStore;

import java.util.ArrayList;

import static constants.Constants.DELIMITER_ARGS;

public class ReceiptGenerator {

    public static Receipt generate(String[] args, IProductStore productStore, ICardStore cardStore) {
        CardDiscount cardDiscount = null;
        ArrayList<ReceiptPosition> receiptPositions = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            String[] line = args[i].split(DELIMITER_ARGS);
            if ("productList".equals(line[0])) {
                //ToDo for file
            } else if ("card".equals(line[0])) {
                cardDiscount = cardStore.getCardDiscountByName(line[1]);


            } else {
                int itemId = Integer.parseInt(line[0]);
                int quantity = Integer.parseInt(line[1]);
                receiptPositions.add(ReceiptPositionFactory.getReceiptPositionClassFromFactory(new Commodity(productStore.getProductById(itemId), quantity), quantity));
            }
        }
        Price[] totals;
        totals = ReceiptCalculator.getTotal(receiptPositions, cardDiscount);
        return new Receipt(receiptPositions, totals[0], totals[1], totals[2], totals[3], cardDiscount);
    }
}
