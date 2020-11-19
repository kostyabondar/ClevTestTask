package beans.receipt;

import beans.Commodity;
import beans.Price;
import beans.card.CardDiscount;
import beans.card.CardListFromCsv;
import beans.card.CardListFromMemory;
import beans.factory.ReceiptPositionFactory;
import beans.interfaces.ICardStore;
import beans.interfaces.IProductStore;
import beans.product.ProductListFromCsv;
import beans.product.ProductListFromMemory;

import java.util.ArrayList;
import java.util.Arrays;

import static constants.Constants.DELIMITER_ARGS;

public class ReceiptGenerator {

    public static Receipt generate(String[] args) {
        CardDiscount cardDiscount = null;
        ArrayList<ReceiptPosition> receiptPositions = new ArrayList<>();
        IProductStore productStore;
        ICardStore cardStore;
        Receipt receipt = null;
        try {
            String[] inputFiles = args[0].split(DELIMITER_ARGS);
            if (inputFiles[0].equals("files")) {
                productStore = new ProductListFromCsv(inputFiles[1]);
                cardStore = new CardListFromCsv(inputFiles[2]);
                args = Arrays.copyOfRange(args, 1, args.length);
            } else {
                productStore = new ProductListFromMemory();
                cardStore = new CardListFromMemory();
            }
            for (String arg : args) {
                String[] line = arg.split(DELIMITER_ARGS);
                if ("card".equals(line[0])) {
                    try {
                        cardDiscount = cardStore.getCardDiscountByName(line[1]);
                    } catch (NullPointerException e) {
                        System.err.println("Not found card with NAME=" + line[1]);
                    }
                } else {
                    int itemId = Integer.parseInt(line[0]);
                    int quantity = Integer.parseInt(line[1]);
                    try {
                        receiptPositions.add(ReceiptPositionFactory.getReceiptPositionClassFromFactory(new Commodity(productStore.getProductById(itemId), quantity), quantity));
                    } catch (NullPointerException e) {
                        System.err.println("Not found product with ID=" + itemId);
                    }
                }
            }
            Price[] totals;
            totals = ReceiptCalculator.getTotal(receiptPositions, cardDiscount);
            receipt = new Receipt(receiptPositions, totals[0], totals[1], totals[2], totals[3], cardDiscount);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Args not found");
            System.exit(0);
        }
        return receipt;
    }

}
