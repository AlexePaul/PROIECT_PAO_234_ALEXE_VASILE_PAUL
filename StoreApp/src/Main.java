import Models.Product;

public class Main {
    public static void main(String[] args) {

    Product p = new Product(5, 2000,"Telefon Smecher");

    System.out.println(p.getName());

    System.out.println(p.getPrice());
    }
}