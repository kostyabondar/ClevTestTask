
import beans.card.CardListFromMemory;
import beans.product.ProductListFromMemory;
import beans.receipt.ReceiptGenerator;
import beans.receipt.ReceiptPrinter;

public class Runner {
    public static void main(String[] args) {

        String[] strings = new String[]{"3-1", "2-10", "4-1", "3-1234", "card-1234"};
        ReceiptPrinter.printReceipt(ReceiptGenerator.generate(strings, new ProductListFromMemory(), new CardListFromMemory()));
    }
}
