package prog;

import gui.LoginPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart implements Serializable {
    private String cartId;
    private ArrayList<Product> cartItems;
    // the constructor for the shopping cart, gets the cart ID and creates a new cart
    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<Product>();
    }
    // returns the current cart ID
    public String getCartId() {
        return cartId;
    }
    // return the items in the current cart
    public ArrayList<Product> getCartItemsArrayList() {
        return cartItems;
    }
    // setting the items inside the current cart
    public void setCartItems(ArrayList<Product> cartItems) {
        this.cartItems = cartItems;
    }
    // adding an item
    public void addCartItem(Product cartItem){
        this.cartItems.add(cartItem);
    }
    // removes item from cart
    public void removeFromCart(Product cartItem){
        this.cartItems.remove(cartItem);
    }
    public void updateQuantity(){

    }

    public void viewCartDetails(){

    }

    public void checkOut(){

    }
}
