package beans.Product;

import beans.Price;

public class Product {
    private int id;
    private String name;
    private Price price;

    public Product(int id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = new Price(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price;
    }
}
