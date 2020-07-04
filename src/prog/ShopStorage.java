package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopStorage implements Serializable {
    private ArrayList<Product> productArrayList;
    private WareHouse wareHouse;

    public ShopStorage() {
        this.productArrayList = new ArrayList<Product>();
        this.wareHouse = new WareHouse();
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void addProduct(Product product){
        this.productArrayList.add(product);
    }

    public void checkWareHouse(){}

    public void returnProductToWareHouse(Product product){
        this.productArrayList.remove(product);
        this.wareHouse.getProductArrayList().add(product);
    }

    public boolean isProductionShop(Product product){
        for(Product product1:productArrayList){
            if(product1.equals(product)){
                return true;
            }
        }
        return false;
    }
}
