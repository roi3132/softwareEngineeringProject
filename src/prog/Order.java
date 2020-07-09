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
    // the constructor for the order, creates a new order and adds it to the order list
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.productArrayList= new ArrayList<Product>();
    }
    // returns the order number
    public int getOrderNumber() {
        return orderNumber;
    }

    // returns the list of products in the order
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
    // set a list of products
    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
    // return which worker is taking care of the order
    public String getWorkerTakingCare() {
        return workerTakingCare;
    }
    // setting which worker is taking care of the order
    public void setWorkerTakingCare(String workerTakingCare) {
        this.workerTakingCare = workerTakingCare;
    }
    // return the customer ID for the order
    public String getCustomerId() {
        return customerId;
    }

    // set the customer ID for the order
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    // returns the address for the order
    public String getAddress() {
        return address;
    }
    // setting the address for the order
    public void setAddress(String address) {
        this.address = address;
    }
    // returns the total amount for the order
    public double getTotalAmount() {
        return totalAmount;
    }
    // set the total amount for the order
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    // return whether the product is in stock
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
