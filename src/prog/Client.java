package prog;

import java.util.ArrayList;

public class Client extends Person {
    private String orderHistory;
    private ArrayList<Order> orderArrayList;
    private enum paymentMethod{CASH,CARD}
    private ShoppingCart currentShoppingCart;


    // the constructor for the Client. get all the details of a customer and creating a new customer.
    public Client(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id,address,gender,email,firstName,lastName,password,accessLevel,userName);
        orderArrayList=new ArrayList<Order>();
        this.accessLevel=AccessLevel.CLIENT;
    }
    // returns the array that contains the orders of the client
    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }
    // returns the shopping cart for the client
    public ShoppingCart getCurrentShoppingCart() {
        return currentShoppingCart;
    }
    // updates the current shopping cart
    public void setCurrentShoppingCart(ShoppingCart currentShoppingCart) {
        this.currentShoppingCart = currentShoppingCart;
    }

    // other function for future use (if needed)
    public void addProductToCart(){};

    public void showOrders(){};

    public void updatePaymentMethod(){};

    public void selectItem(){};

    public void register(){};

    public void login(){};

}
