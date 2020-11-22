package receipt;

import beans.*;
import implementation.card.CardListFromCsv;
import implementation.card.CardListFromMemory;
import implementation.factory.ReceiptPositionFactory;
import implementation.interfaces.ICardStore;
import implementation.interfaces.IProductStore;
import implementation.product.ProductListFromCsv;
import implementation.product.ProductListFromMemory;
import exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

import static constants.Constants.DELIMITER_ARGS;

public class ReceiptGenerator {

    public static Receipt generate(String[] args) {
        DiscountCard discountCard = null;
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
                        discountCard = cardStore.getCardDiscountByName(line[1]);
                    } catch (NotFoundException e) {
                        System.err.println("Not found card with NAME=" + line[1]);
                    }
                } else {
                    int itemId = Integer.parseInt(line[0]);
                    int quantity = Integer.parseInt(line[1]);
                    try {
                        Product product = productStore.getProductById(itemId);
                        receiptPositions.add(ReceiptPositionFactory.getReceiptPositionClassFromFactory(new Commodity(product, quantity), quantity));
                    } catch (NotFoundException e) {
                        System.err.println("Not found product with ID=" + itemId);
                    }
                }
            }
            PriceSummary priceSummary = ReceiptCalculator.getTotal(receiptPositions, discountCard);
            receipt = new Receipt(receiptPositions, priceSummary, discountCard);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Args not found");
            System.exit(0);
        }
        return receipt;
    }

}
