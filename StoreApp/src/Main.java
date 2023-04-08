import Models.Phone;
import Models.Product;
import Models.Store;
import Services.StoreService;
import Utils.Pair;
import Utils.Resolution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Resolution res = new Resolution(2796,1290);
        Phone p = new Phone(1, 6399, "Iphone 14 Pro Max", "A16", res, 120, 256, "Deep Purple");
        //System.out.println(p.getProductType());
        //System.out.println(p.getName());
        //System.out.println(p.getScreenResolution());

        Store store = new Store("Adresa", 1);
        StoreService s = new StoreService();
        s.AddStore(store);
        List<Pair<Integer, Product>> l = s.AddStock(1, p, 3);
        for (Pair<Integer, Product> integerProductPair : l) {
            System.out.println(integerProductPair.First());
        }
    }
}