package implementation.product;

import exceptions.NotFoundException;
import beans.Price;
import beans.Product;
import implementation.interfaces.IProductStore;

import java.util.ArrayList;
import java.util.List;

public class ProductListFromMemory implements IProductStore {
    private List<Product> initialProducts;

    public ProductListFromMemory() {
        this.initialProducts = new ArrayList<>();
        initialProducts.add(new Product(0, "Meet", new Price(10, 1)));
        initialProducts.add(new Product(1, "Fish", new Price(9, 89)));
        initialProducts.add(new Product(2, "Beef", new Price(5, 96)));
        initialProducts.add(new Product(3, "Milk", new Price(3, 22)));
        initialProducts.add(new Product(4, "Smartphone", new Price(180, 0)));
        initialProducts.add(new Product(5, "Ticket", new Price(200, 50)));
    }

    @Override
    public Product getProductById(int id) throws NotFoundException {
        return getProductByIdFromData(id, initialProducts);
    }
}
