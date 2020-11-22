package implementation.product;

import exceptions.NotFoundException;
import beans.Price;
import beans.Product;
import implementation.interfaces.IProductStore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import static constants.Constants.*;

public class ProductListFromCsv implements IProductStore {

    private String fileName;

//    public ProductListFromCsv(String fileName) {
//        this.fileName = "src/" + fileName + ".csv";
//    }
    public ProductListFromCsv(String fileName) {
        this.fileName = PATH_FILES + fileName + CSV;
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
            String[] csvLine = scanner.nextLine().split(REGEX_CSV);

            int productId = Integer.parseInt(csvLine[0]);
            String productName = csvLine[1];
            Price price = new Price(Integer.parseInt(csvLine[2]));

            products.add(new Product(productId, productName, price));
        }
        return products;
    }

    @Override
    public Product getProductById(int id) throws NotFoundException {
        return getProductByIdFromData(id, parseProductListFromCsv());
    }
}
