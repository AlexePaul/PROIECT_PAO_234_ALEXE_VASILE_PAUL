package Services;

import Models.Product;
import Models.Store;
import Utils.Pair;

import java.util.*;

import static java.lang.Math.max;
@SuppressWarnings("unused")
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

    public Set<Product> GetStockGraterThan0(int storeId){
        if(!CheckStore(storeId))
            return null;
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        Set<Product> setP = new HashSet<>();
        for(Pair<Integer, Product> st : s){
            if(st.First() > 0)
                setP.add(st.Second());
        }
        return setP;
    }

    public void checkStock(int storeId){ //this will remove a product from the list if it's stock
        // is 0
        if (!CheckStore(storeId))
            return;
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).First() == 0) {
                s.remove(i);
                i = 0;
            }
        }
    }

    public boolean removeStock(int storeId, int productId, int count){
        if(!CheckStore(storeId))
            return false;
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for(Pair<Integer, Product> st : s) {
            if(st.Second().getProductId() == productId){
                st.SetFirst(max(0,st.First()-count));
                checkStock(storeId);
                return true;
            }
        }
        return false;
    }

    public boolean checkStockOfAProduct(int storeId, int productId) {
        if (!CheckStore(storeId))
            return false;
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for (Pair<Integer, Product> st : s) {
            if (st.Second().getProductId() == productId && st.First() > 0) {
                return true;
            }
        }
        return false;
    }

    public int numberOfStores() {return Stores.size();}
    public int numberOfProductsInStore(int storeId){return Stock.get(storeId).size();}
}
