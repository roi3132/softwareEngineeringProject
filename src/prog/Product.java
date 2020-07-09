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
    // the constructor for a new product, gets all the details for a new product
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    // returns the product name
    public String getProductName() {
        return productName;
    }
    // return the ID of the product
    public String getProductID() {
        return productID;
    }
    // returns the price of the product
    public double getPrice() {
        return price;
    }
    // setting the price of the product
    public void setPrice(double price) {
        this.price = price;
    }
    // returns the description for the product
    public String getDescription() {
        return description;
    }
    // setting the description
    public void setDescription(String description) {
        this.description = description;
    }
    // returns the color of the product
    public Color getColor() {
        return color;
    }
    // setting a color for the product
    public void setColor(Color color) {
        this.color = color;
    }
    // returns the quantity for this product
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // reduces the quantity for this product
    public void deductQuantity(int takenQuantity) {
        this.quantity -= takenQuantity ;
    }
    // increase the quantity of this product
    public void increaseQuantity(int addedQuantity) {
        this.quantity += addedQuantity ;
    }

    // converts the parameters for the product to string
    public String toString(){
//        return productID +"    "+productName+"    "+price+"    "+quantity;
        return String.format( "%-10s %-15s %-15s %-15s",productID,productName,price,quantity );
    }
}
