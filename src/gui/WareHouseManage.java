package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import prog.AccessLevel;
import prog.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class WareHouseManage extends JFrame {

    private JPanel mainPanel;
    private JList WarehouseItemList;
    private JButton addToShopButton;
    private JList shopItemList;
    private JButton backToWarehouseButton;
    private JButton removeItemButton;
    private JFrame previousWindow;
    private JFrame currentWindow;
    private ArrayList<Product> currentShopProductList;
    private ArrayList<Product> currentWarehouseProductList;
    private ArrayList<String> productListOfWarehouseSection;
    private ArrayList<String> productListOfShopSection;


    public WareHouseManage(JFrame previousWindow) throws HeadlessException {

        if (!LoginPage.getMainDriver().getCurrentUser().getAccessLevel().equals(AccessLevel.MANAGER)) {
            backToWarehouseButton.setVisible(false);
        } else {
            backToWarehouseButton.setVisible(true);
        }
        addToShopButton.setVisible(true);

        this.previousWindow = previousWindow;
        this.currentWindow = this;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
//        this.setLocationRelativeTo(null);
        this.setLocation(170, 200);
        this.setSize(1000, 400);
        this.WarehouseItemList.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.shopItemList.setFont(new Font("monospaced", Font.PLAIN, 12));
//        this.pack();


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                previousWindow.setVisible(true);
            }
        });
        setProducts();
        setShopProducts();


        //Add from warehouse to shop
        addToShopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedProduct = (String) WarehouseItemList.getSelectedValue();
                Product selectedProductObject = getSelectedObject(selectedProduct, currentWarehouseProductList);
                int index = LoginPage.getMainDriver().getWarehouseProductList().indexOf(selectedProductObject);
                int addingQty;
                int checkIndex = getIndexOfArrayListObject(LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList(), selectedProductObject);


                if (index >= 0) {
                    addingQty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity to add "));
                    if (addingQty > selectedProductObject.getQuantity()) {
                        JOptionPane.showMessageDialog(mainPanel, "Maximum quantity exceeded.");
                    } else if (addingQty <= 0) {
                        JOptionPane.showMessageDialog(mainPanel, "Invalid Amount. Please ReEnter");
                    }

                    //if selected product is not in shop we must add it
                    else if (checkIndex < 0) {
                        Product productToAdd = new Product(selectedProductObject.getProductName(), selectedProductObject.getProductID(), selectedProductObject.getPrice(), addingQty);
                        LoginPage.getMainDriver().getWarehouseProductList().get(index).deductQuantity(addingQty);

                        // if warehouse product quantity is 0, we must delete it from warehouse product list.
//                        if (LoginPage.getMainDriver().getWarehouseProductList().get(index).getQuantity() == 0) {
//                            LoginPage.getMainDriver().getWarehouseProductList().remove(index);
//                        }

                        LoginPage.getMainDriver().getShop().getShopStorage().addProduct(productToAdd);
                        setShopProducts();
                        setProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");
                    }

                    //if selected product is already in shop storage we should only update quantity
                    else if (checkIndex >= 0) {
                        int existingProductIndex = checkIndex;
                        LoginPage.getMainDriver().getWarehouseProductList().get(index).deductQuantity(addingQty);

                        // if warehouse product quantity is 0, we must delete it from warehouse product list.
//                        if (LoginPage.getMainDriver().getWarehouseProductList().get(index).getQuantity() == 0) {
//                            LoginPage.getMainDriver().getWarehouseProductList().remove(index);
//                        }

                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(existingProductIndex).increaseQuantity(addingQty);
                        setShopProducts();
                        setProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");

                    }

                }
            }
        });


        //Add from shop to warehouse
        backToWarehouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) shopItemList.getSelectedValue();
                Product selectedProductObject = getSelectedObject(selectedProduct, currentShopProductList);
                int index = LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().indexOf(selectedProductObject);
                int addingQty;
                int checkIndex = getIndexOfArrayListObject(LoginPage.getMainDriver().getWarehouseProductList(), selectedProductObject);

                if (index >= 0) {
                    addingQty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity to be Returned "));
                    if (addingQty > selectedProductObject.getQuantity()) {
                        JOptionPane.showMessageDialog(mainPanel, "Maximum quantity exceeded.");
                    } else if (addingQty <= 0) {
                        JOptionPane.showMessageDialog(mainPanel, "Invalid Amount. Please ReEnter");
                    }

                    //if selected product is not in warehouse we must add it
                    else if (checkIndex < 0) {
                        Product productToAdd = new Product(selectedProductObject.getProductName(), selectedProductObject.getProductID(), selectedProductObject.getPrice(), addingQty);
                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).deductQuantity(addingQty);

                        // if warehouse product quantity is 0, we must delete it from warehouse product list.
//                        if (LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).getQuantity() == 0) {
//                            LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().remove(index);
//                        }

                        LoginPage.getMainDriver().getWarehouseProductList().add(productToAdd);
                        setShopProducts();
                        setProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");
                    }

                    //if selected product is already in shop storage we should only update quantity
                    else if (checkIndex >= 0) {
                        int existingProductIndex = checkIndex;
                        LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).deductQuantity(addingQty);

                        // if warehouse product quantity is 0, we must delete it from warehouse product list.
//                        if (LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().get(index).getQuantity() == 0) {
//                            LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().remove(index);
//                        }

                        LoginPage.getMainDriver().getWarehouseProductList().get(existingProductIndex).increaseQuantity(addingQty);
                        setShopProducts();
                        setProducts();

                        JOptionPane.showMessageDialog(mainPanel, "Adding is Success.");

                    }

                }

            }
        });
    }


    private void setProducts() {
        this.currentWarehouseProductList = LoginPage.getMainDriver().getWarehouseProductList();
        Vector<String> warehouseList = new Vector<String>();

        warehouseList.addElement(String.format("%-10s %-15s %-15s %-15s", "ID", "Product", "Price(USD)", "Quantity"));
        for (int i = 0; i < LoginPage.getMainDriver().getWarehouseProductList().size(); i++) {
            warehouseList.addElement(currentWarehouseProductList.get(i).toString());
        }

        WarehouseItemList.setListData(warehouseList);
    }

    private Product getSelectedObject(String stringFromVector, ArrayList<Product> productArrayList) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).toString().equals(stringFromVector)) {

                return productArrayList.get(i);

            }
        }
        return null;

    }

    private void setShopProducts() {
        this.currentShopProductList = LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList();
        Vector<String> shopProductList = new Vector<String>();

        shopProductList.addElement(String.format("%-10s %-15s %-15s %-15s", "ID", "Product", "Price(USD)", "Quantity"));
        for (int i = 0; i < LoginPage.getMainDriver().getShop().getShopStorage().getProductArrayList().size(); i++) {
            shopProductList.addElement(currentShopProductList.get(i).toString());
        }

        shopItemList.setListData(shopProductList);
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(mainPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        WarehouseItemList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        WarehouseItemList.setModel(defaultListModel1);
        mainPanel.add(WarehouseItemList, new GridConstraints(1, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        addToShopButton = new JButton();
        addToShopButton.setText("Add To Shop");
        mainPanel.add(addToShopButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shopItemList = new JList();
        mainPanel.add(shopItemList, new GridConstraints(1, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        backToWarehouseButton = new JButton();
        backToWarehouseButton.setText("Back to warehouse");
        mainPanel.add(backToWarehouseButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Available Products in Warehouse");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Available Products in Shop");
        mainPanel.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
