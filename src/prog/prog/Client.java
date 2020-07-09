package prog;

import java.util.ArrayList;

public class Client extends Person {
    private String orderHistory;
    private ArrayList<Order> orderArrayList;
    private enum paymentMethod{CASH,CARD}
    private ShoppingCart currentShoppingCart;



    public Client(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        super(id,address,gender,email,firstName,lastName,password,accessLevel,userName);
        orderArrayList=new ArrayList<Order>();
        this.accessLevel=AccessLevel.CLIENT;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public ShoppingCart getCurrentShoppingCart() {
        return currentShoppingCart;
    }

    public void setCurrentShoppingCart(ShoppingCart currentShoppingCart) {
        this.currentShoppingCart = currentShoppingCart;
    }

    public void addProductToCart(){};

    public void showOrders(){};

    public void updatePaymentMethod(){};

    public void selectItem(){};

    public void register(){};

    public void login(){};

}
