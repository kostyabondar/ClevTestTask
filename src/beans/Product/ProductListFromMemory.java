package beans.Product;

import beans.interfaces.IInputData;

import java.util.ArrayList;
import java.util.List;

public class ProductListFromMemory implements IInputData {
    private  List<Product> products;

    public ProductListFromMemory() {

    }

    @Override
    public List<Product> getProductList() {
        products = new ArrayList<>();
        products.add(new Product(0, "Meet", 1001));
        products.add(new Product(1, "Fish", 989));
        products.add(new Product(2, "Beef", 596));
        products.add(new Product(3, "Milk", 322));
        products.add(new Product(4, "Smartphone", 35854));
        products.add(new Product(5, "Ticket", 111555154));
        return products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //
//    public static List<Product> getInstance() {
//        if (products == null) {
//            products = new ArrayList<>();
//            products.add(new Product(0, "Meet", 1001));
//            products.add(new Product(1, "Fish", 989));
//            products.add(new Product(2, "Beef", 596));
//            products.add(new Product(3, "Milk", 322));
//            products.add(new Product(4, "Smartphone", 35854));
//            products.add(new Product(5, "Ticket", 111555154));
//        }
//        return products;
//    }

}
