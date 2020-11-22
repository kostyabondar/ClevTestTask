package implementation.interfaces;

import beans.Product;
import exceptions.NotFoundException;

import java.util.List;

public interface IProductStore {

    Product getProductById(int id) throws NotFoundException;

    default Product getProductByIdFromData(int id, List<Product> data) throws NotFoundException {
        for (Product product : data) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new NotFoundException();
    }

}
