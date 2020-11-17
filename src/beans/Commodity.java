package beans;

public class Commodity {
    private Product product;
    private int units;


    public Commodity(Product product, int units) {
        this.product = product;
        this.units = units;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Price getTaxableTotalPriceCommodity() {
        return new Price(product.getPrice().mul(units));
    }

    public Price getTotalPriceCommodity() {
        return getTaxableTotalPriceCommodity();
    }

    @Override
    public String toString() {
        return product + "\t" + units + "\t" + getTotalPriceCommodity();
    }
}
