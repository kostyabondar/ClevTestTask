package beans;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static List<Product> products;

    private ProductList() {
    }

    public static List<Product> getInstance() {
        if (products == null) {
            products = new ArrayList<>();
            products.add(new Product(0, "Meet", 1001));
            products.add(new Product(1, "Fish", 989));
            products.add(new Product(2, "Beef", 596));
            products.add(new Product(3, "Milk", 322));
            products.add(new Product(4, "Smartphone", 35854));
            products.add(new Product(5, "Ticket", 111555154));
        }
        return products;
    }

}
