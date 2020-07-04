package prog;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private int orderNumber;
    private ArrayList<Product> productArrayList;
    private String workerTakingCare;
    private String customerId;
    private enum status{READY,NOTREADY};
    private String address;
    private double totalAmount;
    private boolean isInStock;
    private boolean isPaid;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.productArrayList= new ArrayList<Product>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public String getWorkerTakingCare() {
        return workerTakingCare;
    }

    public void setWorkerTakingCare(String workerTakingCare) {
        this.workerTakingCare = workerTakingCare;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
