package Models;

public class Product {

    private int ProductId;
    private int Price;
    private String Name;

    public Product(int productId, int price, String name) {
        ProductId = productId;
        Price = price;
        Name = name;
    }

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
