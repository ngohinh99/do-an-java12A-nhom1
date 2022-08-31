package Repository;

import java.util.HashMap;

import Data.Data;

public class CartRepository {
    private HashMap<String, String> carts;
    public CartRepository(){
        this.carts = Data.carts;
    }
}
