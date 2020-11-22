
import receipt.ReceiptGenerator;
import receipt.ReceiptPrinter;

public class Runner {
    public static void main(String[] args) {

        ReceiptPrinter printer = new ReceiptPrinter();
        printer.printReceiptToConsoleAndSaveInFile(ReceiptGenerator.generate(args));

    }
}
