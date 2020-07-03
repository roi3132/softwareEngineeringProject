package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import prog.Client;
import prog.Product;
import prog.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

public class Shop extends JFrame {
    private JList shopItemList1;
    private JButton addToCartButton;
    private JList shopCartList;
    private JButton checkoutButton;
    private JButton removeItemButton;
    private JPanel mainPanel;
    private JFrame previousWindow;
    private JFrame currentWindow;
    private ArrayList<Product> currentShopProductList;
    private Client client;
    private ArrayList<Product> cartItemList;

    private ArrayList<Product> currentCartProductList;


    public Shop(String title, JFrame previousWindow) throws HeadlessException {
        super(title);
        this.previousWindow = previousWindow;
        this.currentWindow = this;
        this.client = (Client) LoginPage.getMainDriver().getCurrentUser();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
//        this.setLocationRelativeTo(null);
        this.setLocation(170, 200);
        this.setSize(1000, 400);
        this.shopCartList.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.shopItemList1.setFont(new Font("monospaced", Font.PLAIN, 12));
//        this.pack();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String cartID = LoginPage.getMainDriver().getCurrentUser().getUserName() + date;
        ShoppingCart shoppingCart = new ShoppingCart(cartID);
        client.setCurrentShoppingCart(shoppingCart);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                previousWindow.setVisible(true);
            }
        });

        setShopProducts();
        setCartItemProducts();


        //Add from shop to cart
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedProduct = (String) shopItemList1.getSelectedValue();
                Product selectedProductObject = getSelectedObject(selectedProduct, currentShopProductList);
                int index = LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().indexOf(selectedProductObject);
                int addingQty;
                int checkingIndex = getIndexOfArrayListObject(client.getCurrentShoppingCart().getCartItemsArrayList(), selectedProductObject);


                if (index >= 0) {
                    addingQty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity to add "));
                    if (addingQty > selectedProductObject.getQuantity()) {
                        JOptionPane.showMessageDialog(mainPanel, "Maximum quantity exceeded.");
                    } else if (addingQty <= 0) {
                        JOptionPane.showMessageDialog(mainPanel, "Invalid Amount. Please ReEnter");
                    }
                    //if selected product is not in cart we must add it
                    else if (checkingIndex < 0) {
                        Product productToAdd = new Product(selectedProductObject.getProductName(), selectedProductObject.getProductID(), selectedProductObject.getPrice(), addingQty);
                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).deductQuantity(addingQty);

                        // if Shop shop quantity becomes 0, we must delete it from shop product list.
                        if (LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).getQuantity() == 0) {
                            LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().remove(index);
                        }

                        client.getCurrentShoppingCart().addCartItem(productToAdd);
                        setCartItemProducts();
                        setShopProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Added to cart");
                    }

                    //if selected product is already in cart we should only update quantity
                    else if (checkingIndex >= 0) {
                        int existingProductIndex = checkingIndex;
                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).deductQuantity(addingQty);

                        // if shop product quantity is 0, we must delete it from shop product list.
                        if (LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).getQuantity() == 0) {
                            LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().remove(index);
                        }

                        client.getCurrentShoppingCart().getCartItemsArrayList().get(existingProductIndex).increaseQuantity(addingQty);
                        setCartItemProducts();
                        setShopProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");

                    }

                }
            }
        });


        //Return an item to shop
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedProduct = (String) shopCartList.getSelectedValue();
                Product selectedProductObject = getSelectedObject(selectedProduct, currentCartProductList);
                int index = client.getCurrentShoppingCart().getCartItemsArrayList().indexOf(selectedProductObject);
                int addingQty;
                int checkingIndex = getIndexOfArrayListObject(LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList(), selectedProductObject);


                if (index >= 0) {
                    addingQty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity to return "));
                    if (addingQty > selectedProductObject.getQuantity()) {
                        JOptionPane.showMessageDialog(mainPanel, "Maximum quantity exceeded.");
                    } else if (addingQty <= 0) {
                        JOptionPane.showMessageDialog(mainPanel, "Invalid Amount. Please ReEnter");
                    }

                    //if selected product is not in shop we must add it
                    else if (checkingIndex < 0) {
                        Product productToAdd = new Product(selectedProductObject.getProductName(), selectedProductObject.getProductID(), selectedProductObject.getPrice(), addingQty);
                        client.getCurrentShoppingCart().getCartItemsArrayList().get(index).deductQuantity(addingQty);
                        currentShopProductList.add(productToAdd);

                        // if cart product quantity becomes 0, we must delete it from cart product list.
                        if (client.getCurrentShoppingCart().getCartItemsArrayList().get(index).getQuantity() == 0) {
                            client.getCurrentShoppingCart().getCartItemsArrayList().remove(index);
                        }


                        setCartItemProducts();
                        setShopProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");
                    }

                    //if selected product is already in shop we should only update quantity
                    else if (checkingIndex >= 0) {
                        System.out.println("already in list");
                        int existingProductIndex = checkingIndex;
                        System.out.println(existingProductIndex);
                        client.getCurrentShoppingCart().getCartItemsArrayList().get(index).deductQuantity(addingQty);
                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(existingProductIndex).increaseQuantity(addingQty);

                        // if cart product quantity becomes 0, we must delete it from cart product list.
                        if (client.getCurrentShoppingCart().getCartItemsArrayList().get(index).getQuantity() == 0) {
                            client.getCurrentShoppingCart().getCartItemsArrayList().remove(index);
                        }


                        setCartItemProducts();
                        setShopProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Return successful");

                    }

                }

            }
        });
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame checkOut = new CheckOut(currentWindow);
                checkOut.setVisible(true);
                currentWindow.setVisible(false);
                
                client.getCurrentShoppingCart().getCartItemsArrayList().clear();
                setCartItemProducts();
            }
        });
    }


    private void setShopProducts() {
        this.currentShopProductList = LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList();
        Vector<String> shopList = new Vector<String>();

        shopList.addElement(String.format("%-10s %-15s %-15s %-15s", "ID", "Product", "Price(USD)", "Quantity"));

        for (int i = 0; i < currentShopProductList.size(); i++) {
            shopList.addElement(currentShopProductList.get(i).toString());
        }

        shopItemList1.setListData(shopList);
    }

    private Product getSelectedObject(String stringFromVector, ArrayList<Product> productArrayList) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).toString().equals(stringFromVector)) {

                return productArrayList.get(i);

            }
        }
        return null;

    }

    private void setCartItemProducts() {
        this.currentCartProductList = client.getCurrentShoppingCart().getCartItemsArrayList();
        Vector<String> shopProductList = new Vector<String>();
        shopProductList.addElement(String.format("%-10s %-15s %-15s %-15s", "ID", "Product", "Price(USD)", "Quantity"));

        for (int i = 0; i < currentCartProductList.size(); i++) {
            shopProductList.addElement(currentCartProductList.get(i).toString());
        }

        shopCartList.setListData(shopProductList);
    }

    public int getIndexOfArrayListObject(ArrayList<Product> productArrayList, Product inputProduct) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getProductID().equals(inputProduct.getProductID())) {
                return i;
            }
        }
        return -1;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        shopItemList1 = new JList();
        mainPanel.add(shopItemList1, new GridConstraints(1, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        addToCartButton = new JButton();
        addToCartButton.setText("Add To Cart");
        mainPanel.add(addToCartButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shopCartList = new JList();
        mainPanel.add(shopCartList, new GridConstraints(1, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        checkoutButton = new JButton();
        checkoutButton.setText("Checkout");
        mainPanel.add(checkoutButton, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeItemButton = new JButton();
        removeItemButton.setText("Remove Item");
        mainPanel.add(removeItemButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Shop Items");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Your Cart");
        mainPanel.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
