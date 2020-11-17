package factory;

import beans.Commodity;
import beans.DiscountCommodity;
import beans.Product;
import constants.Constants;

public class CommodityFactory {

//    public static Commodity getCommodityClassFromFactory(Product product, int quantity) {
//        Commodity commodity = new Commodity(product,quantity);
//        if (quantity > Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THEN) {
//            return new DiscountCommodity(commodity);
//        }
//        else return commodity;
//    }

    public static Commodity getCommodityClassFromFactory(Product product, int quantity) {

        if (quantity > Constants.QUANTITY_COMMODITY_FOR_DISCOUNT_MORE_THEN) {
            return new DiscountCommodity(product,quantity);
        }
        else return new Commodity(product,quantity);
    }
}
