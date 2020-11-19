package beans.product;

import beans.interfaces.IProductStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductListFromMemory implements IProductStore {
    private static List<Product> initialProducts = getInitialProducts();

    private List<Product> productList;

    public ProductListFromMemory() {
        this.productList = new ArrayList<>();
    }

    public static List<Product> getInitialProducts() {
        initialProducts = new ArrayList<>();
        initialProducts.add(new Product(0, "Meet", 1001));
        initialProducts.add(new Product(1, "Fish", 989));
        initialProducts.add(new Product(2, "Beef", 596));
        initialProducts.add(new Product(3, "Milk", 322));
        initialProducts.add(new Product(4, "Smartphone", 35854));
        initialProducts.add(new Product(5, "Ticket", 111555154));
        initialProducts.sort((o1, o2) -> o1.getId() - o2.getId());
        return initialProducts;
    }


    @Override
    public List<Product> getProductList() {
        return productList;
    }


    @Override
    public Product getProductById(int id) {
        Product productById = new Product();
        for (Product product :
                initialProducts) {
            if (product.getId() == id){
                productById = product;
                break;
            }
        }
        productList.add(productById);
        return productById;
    }

    public List<Product> getProducts() {
        return initialProducts;
    }

    public void setProducts(List<Product> products) {
        this.initialProducts = products;
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
