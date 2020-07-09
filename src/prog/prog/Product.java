package prog;

import java.awt.*;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String productID;
    private double price;
    private String description;
    private Color color;
    private int quantity;

    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void deductQuantity(int takenQuantity) {
        this.quantity -= takenQuantity ;
    }

    public void increaseQuantity(int addedQuantity) {
        this.quantity += addedQuantity ;
    }


    public String toString(){
//        return productID +"    "+productName+"    "+price+"    "+quantity;
        return String.format( "%-10s %-15s %-15s %-15s",productID,productName,price,quantity );
    }
}
