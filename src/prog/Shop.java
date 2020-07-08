package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
    private String address;
    private ArrayList<Worker> workerArrayList;
    private Manager manager;
    private ArrayList<Order> orderArrayList;
    private ShopStorage shopStorage;
    // the constructor for the shop, creates a new shop with address and a storage
    public Shop(String address) {
        this.address = address;
        this.shopStorage = new ShopStorage();
    }
    //returns the address of the shop
    public String getAddress() {
        return address;
    }
    // setting the address for the shop
    public void setAddress(String address) {
        this.address = address;
    }
    // returns the shop list
    public ArrayList<Worker> getWorkerArrayList() {
        return workerArrayList;
    }
    // setting the workers in the shop
    public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
        this.workerArrayList = workerArrayList;
    }
    // returns the manager for the shop
    public Manager getManager() {
        return manager;
    }
    // setting the manager for the shop
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    // returns the orders for the shop
    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }
    // setting the order for the shop
    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }
    // returns the item in the store
    public ShopStorage getShopStorage() {
        return shopStorage;
    }
    // setting the items in the shop
    public void setShopStorage(ShopStorage shopStorage) {
        this.shopStorage = shopStorage;
    }

    // other functions to be used later on
    public void addWorker(){}
    public void showWorkers(){}
    public void printShift(){}
    public void changeManager(){}

}
