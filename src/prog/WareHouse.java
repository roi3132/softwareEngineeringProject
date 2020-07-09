package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class WareHouse implements Serializable {
    private String address;
    private ArrayList<Worker> workerArrayList;
    private Manager manager;
    private ArrayList<Shop> shopArrayList;
    private ArrayList<Product> productArrayList;
    private double amount;
    // returns the address of the warehouse
    public String getAddress() {
        return address;
    }
    // setting the address for the warehouse
    public void setAddress(String address) {
        this.address = address;
    }
    // returns the worker array list
    public ArrayList<Worker> getWorkerArrayList() {
        return workerArrayList;
    }
    // setting the workers
    public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
        this.workerArrayList = workerArrayList;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Shop> getShopArrayList() {
        return shopArrayList;
    }

    public void setShopArrayList(ArrayList<Shop> shopArrayList) {
        this.shopArrayList = shopArrayList;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
