package Services;

import Models.Product;
import Models.Store;
import Utils.Pair;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;

public class StoreService implements GenericService<Store> {
    List<Store> Stores = new ArrayList<>();
    TreeMap<Integer, List<Pair<Integer, Product>>> Stock = new TreeMap<>();
    public List<Store> GetAll(){
        return Stores;
    }
    public void AddStore(Store StoreToAdd){
       Stores.add(StoreToAdd);
    }
    public List<Pair<Integer, Product>> AddStock(int storeId, Product product, int count){
        if(!Stock.containsKey(storeId)){
            List<Pair<Integer, Product>>  s = new ArrayList<>();
            s.add(new Pair<>(count, product));
            Stock.put(storeId,s);
            List<Pair<Integer, Product>> l = Stock.get(storeId);
            return l;
        }
        else{
            List<Pair<Integer, Product>> s = Stock.get(storeId);
            boolean ok = false;
            for (Pair<Integer, Product> integerProductPair : s) {
                if (integerProductPair.Second() == product) {
                    integerProductPair.SetFirst(integerProductPair.First() + count);
                    ok = true;
                }
            }
            if(!ok){
                s.add(new Pair<>(count, product));
            }
            return Stock.replace(storeId,s);
        }
    }
}
