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
	
	
}