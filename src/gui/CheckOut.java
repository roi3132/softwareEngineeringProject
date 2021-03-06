package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import prog.Client;
import prog.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class CheckOut extends JFrame {
    private JList checkOutList;
    private JPanel panel1;
    private JTextField totalAmountText;
    private JTextField totalAmountUSDTextField;
    private JFrame previousWindow;
    private Client client;
    private ArrayList<Product> currentCheckoutProductList;

    public CheckOut(JFrame previousWindow) {


        this.previousWindow = previousWindow;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.setSize(400, 400);
        this.setLocation(500, 200);
        this.checkOutList.setFont(new Font("monospaced", Font.PLAIN, 12));

        this.client = (Client) LoginPage.getMainDriver().getCurrentUser();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                previousWindow.setVisible(true);
            }
        });

        setCheckoutProducts();


    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < client.getCurrentShoppingCart().getCartItemsArrayList().size(); i++) {
            total += client.getCurrentShoppingCart().getCartItemsArrayList().get(i).getQuantity() *
                    client.getCurrentShoppingCart().getCartItemsArrayList().get(i).getPrice();
        }
        return total;
    }

    private void setCheckoutProducts() {
        if (!client.getCurrentShoppingCart().getCartItemsArrayList().isEmpty()) {
            this.currentCheckoutProductList = client.getCurrentShoppingCart().getCartItemsArrayList();
            Vector<String> CheckOutList = new Vector<String>();
            CheckOutList.addElement(String.format("%-10s %-15s %-15s %-15s", "ID", "Product", "Price(USD)", "Quantity"));

            for (int i = 0; i < currentCheckoutProductList.size(); i++) {
                CheckOutList.addElement(currentCheckoutProductList.get(i).toString());
            }
            checkOutList.setListData(CheckOutList);
            double total = this.calculateTotal();
            this.totalAmountText.setText(Double.toString(total));
        } else {
            String[] strings = new String[1];
            strings[0] = "No Any Items in your cart.";

            checkOutList.setListData(strings);
            this.totalAmountUSDTextField.setText("Please Add Items");
        }
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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        checkOutList = new JList();
        panel1.add(checkOutList, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        totalAmountText = new JTextField();
        panel1.add(totalAmountText, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        totalAmountUSDTextField = new JTextField();
        totalAmountUSDTextField.setText("Total Amount (USD) :");
        panel1.add(totalAmountUSDTextField, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
