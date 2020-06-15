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

    public String getCartId() {
        return cartId;
    }

    public ArrayList<Product> getCartItemsArrayList() {
        return cartItems;
    }

    public void setCartItems(ArrayList<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(Product cartItem){
        this.cartItems.add(cartItem);
    }

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
