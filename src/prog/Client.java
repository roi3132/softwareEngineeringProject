package prog;

import java.util.ArrayList;

public class Client extends Person {
    private String orderHistory;
    private ArrayList<Order> orderArrayList;
    private enum paymentMethod{CASH,CARD}
    private ShoppingCart currentShoppingCart;


    //the constructor of the client itself, all the details of the customer are being put in the array here
    public Client(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id,address,gender,email,firstName,lastName,password,accessLevel,userName);
        orderArrayList=new ArrayList<Order>();
        this.accessLevel=AccessLevel.CLIENT;
    }
    // returns the array of clients
    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }
    // returns the shopping cart
    public ShoppingCart getCurrentShoppingCart() {
        return currentShoppingCart;
    }
    // updates the shopping cart for the current client
    public void setCurrentShoppingCart(ShoppingCart currentShoppingCart) {
        this.currentShoppingCart = currentShoppingCart;
    }


    // other functions for us to add to the project
    public void addProductToCart(){};

    public void showOrders(){};

    public void updatePaymentMethod(){};

    public void selectItem(){};

    public void register(){};

    public void login(){};

}
