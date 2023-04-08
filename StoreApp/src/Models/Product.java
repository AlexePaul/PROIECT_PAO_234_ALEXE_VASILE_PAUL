package Models;
@SuppressWarnings("unused")
abstract public class Product {

    protected int ProductId;
    protected int Price;
    protected String Name;

    public Product() {
    }

    public Product(int productId, int price, String name) {
        ProductId = productId;
        Price = price;
        Name = name;
    }

    public abstract String getProductType();
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProductId() {
        return ProductId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
