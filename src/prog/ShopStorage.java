package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopStorage implements Serializable {
    private ArrayList<Product> productArrayList;
    private WareHouse wareHouse;
    // the constructor for the shop storage. contains all the items in the shop
    public ShopStorage() {
        this.productArrayList = new ArrayList<Product>();
        this.wareHouse = new WareHouse();
    }
    // returns the product list
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
    // adds a product to the shop storage
    public void addProduct(Product product){
        this.productArrayList.add(product);
    }

    public void checkWareHouse(){}
    // returns the product back to the warehouse from the shop storage
    public void returnProductToWareHouse(Product product){
        this.productArrayList.remove(product);
        this.wareHouse.getProductArrayList().add(product);
    }


    // checks if the product is in the shop storage
    public boolean isProductionShop(Product product){
        for(Product product1:productArrayList){
            if(product1.equals(product)){
                return true;
            }
        }
        return false;
    }
}
