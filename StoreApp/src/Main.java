import Models.Phone;
import Utils.Resolution;

public class Main {
    public static void main(String[] args) {
        Resolution res = new Resolution(2796,1290);
        Phone p = new Phone(5, 6399, "Iphone 14 Pro Max", "A16", res, 120, 256, "Deep Purple");
        System.out.println(p.getProductType());
        System.out.println(p.getName());
        System.out.println(p.getScreenResolution());


    }
}