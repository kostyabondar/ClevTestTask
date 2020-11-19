
import beans.receipt.ReceiptGenerator;
import beans.receipt.ReceiptPrinter;

public class Runner {
    public static void main(String[] args) {

        //        String[] strings = new String[]{"files-productList-cardList", "1-1", "2-10", "3-1", "44-1234", "card-1234 444"};
//        String[] strings = new String[]{ "1-1", "2-10", "3-1", "44-1234", "card-412"};
        ReceiptPrinter.printReceiptToConsoleAndSaveInFile(ReceiptGenerator.generate(args));
    }
}
