package beans.product;

import beans.interfaces.IProductStore;

import java.util.ArrayList;
import java.util.List;

public class ProductListFromMemory implements IProductStore {
    private static List<Product> initialProducts = getInitialProducts();

    private List<Product> productList;

    public ProductListFromMemory() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return initialProducts;
    }

    public void setProducts(List<Product> products) {
        this.initialProducts = products;
    }

    public static List<Product> getInitialProducts() {
        initialProducts = new ArrayList<>();
        initialProducts.add(new Product(0, "Meet", 1001));
        initialProducts.add(new Product(1, "Fish", 989));
        initialProducts.add(new Product(2, "Beef", 596));
        initialProducts.add(new Product(3, "Milk", 322));
        initialProducts.add(new Product(4, "Smartphone", 35854));
        initialProducts.add(new Product(5, "Ticket", 111555154));
        return initialProducts;
    }

    @Override
    public Product getProductById(int id) {
        Product productById = null;
        for (Product product :
                initialProducts) {
            if (product.getId() == id) {
                productById = product;
                break;
            }
        }
        productList.add(productById);
        return productById;
    }
}
