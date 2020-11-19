package beans.interfaces;

import beans.product.Product;

import java.util.List;

public interface IProductStore {

    List<Product> getProductList();
    Product getProductById(int id);
}
