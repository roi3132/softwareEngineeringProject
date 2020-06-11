package prog;

import gui.LoginPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart implements Serializable {
    private String cartId;
    private ArrayList<Product> cartItems;

    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<Product>();
    }