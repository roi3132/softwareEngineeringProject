package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
    private String address;
    private ArrayList<Worker> workerArrayList;
    private Manager manager;
    private ArrayList<Order> orderArrayList;
    private ShopStorage shopStorage;

    public Shop(String address) {
        this.address = address;
        this.shopStorage = new ShopStorage();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Worker> getWorkerArrayList() {
        return workerArrayList;
    }

    public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
        this.workerArrayList = workerArrayList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public ShopStorage getShopStorage() {
        return shopStorage;
    }

    public void setShopStorage(ShopStorage shopStorage) {
        this.shopStorage = shopStorage;
    }

    public void addWorker(){}
    public void showWorkers(){}
    public void printShift(){}
    public void changeManager(){}

}
