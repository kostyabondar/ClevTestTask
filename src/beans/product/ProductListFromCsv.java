package beans.product;

import beans.Price;
import beans.interfaces.IProductStore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductListFromCsv implements IProductStore {

    private String fileName;

    public ProductListFromCsv(String fileName) {
        this.fileName = "src/" + fileName + ".csv";
    }

    private ArrayList<Product> parseProductListFromCsv() {
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("file " + fileName + "not found");
            System.exit(0);
        }
        while (scanner.hasNext()) {
            String[] csvLine = scanner.nextLine().split(";");
            products.add(new Product(Integer.parseInt(csvLine[0]), csvLine[1], new Price(Integer.parseInt(csvLine[2]))));
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product productById = null;
        for (Product product :
                parseProductListFromCsv()) {
            if (product.getId() == id) {
                productById = product;
                break;
            }
        }
        return productById;
    }
}
