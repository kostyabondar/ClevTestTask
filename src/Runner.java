import beans.CommodityList;

public class Runner {
    public static void main(String[] args) {
        String [] inputArgs = new String[]{"3-1", "2-10", "4-1"};

        CommodityList commodityList = new CommodityList(args);
        commodityList.printCheck();
    }
}
