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

    public boolean CheckStore(int storeId){
        for(Store st : Stores)
            if (st.getStoreId() == storeId) {
                return true;
            }
        return false;
    }
    public boolean AddStore(Store StoreToAdd){
        boolean checkStore = false;
        for(Store st : Stores)
            if (st == StoreToAdd) {
                checkStore = true;
                break;
            }
        if(checkStore)
            return false;
        Stores.add(StoreToAdd);
        return true;
    }
    public List<Pair<Integer, Product>> AddStock(int storeId, Product product, int count){
        boolean checkStore = false;
        for(Store st : Stores)
            if (st.getStoreId() == storeId) {
                checkStore = true;
                break;
            }
        if(!checkStore)
            return null;
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

    public List<Pair<Integer, Product>> CheckStock(int storeId){
        return Stock.get(storeId);
    }
}
