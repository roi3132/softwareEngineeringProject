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

    // the constructor for the order, receives the order number and adds it to the array of orders
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.productArrayList= new ArrayList<Product>();
    }
    //returns the number for the current order
    public int getOrderNumber() {
        return orderNumber;
    }

    // returns the list of products
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
    // returns which worker takes take of the order
    public String getWorkerTakingCare() {
        return workerTakingCare;
    }
    // setting which worker is taking of the product
    public void setWorkerTakingCare(String workerTakingCare) {
        this.workerTakingCare = workerTakingCare;
    }
    // returns the costumer ID
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
