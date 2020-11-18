import beans.receipt.Receipt;

public class Runner {
    public static void main(String[] args) {

//        CommodityList commodityList = new CommodityList(args);
//        commodityList.printCheck();

        String[] strings = new String[]{"3-1", "2-10", "4-1", "123123-1234"};
        Receipt receipt = new Receipt(strings);
//        List<ReceiptPosition> positions = receipt.parseArgsToListReceiptPosition(args);
        receipt.getReceipt();
    }
}
