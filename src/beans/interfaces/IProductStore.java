package beans.interfaces;

import beans.product.Product;

public interface IProductStore {

//    List<Product> getProductList();
    Product getProductById(int id);

}
