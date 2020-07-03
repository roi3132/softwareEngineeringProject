package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import prog.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginPage extends JFrame {
    private JButton signIn;
    private JButton signUp;
    private JTextField userNameField;
    private JPanel loginWindow;
    private JPasswordField passwordField;
    private static MainDriver mainDriver;
    private JFrame currentWindow;
    private FileHandler fileHandler;

    private String adminName;
    private String adminPassword;


    public static MainDriver getMainDriver() {
        return mainDriver;
    }

    public LoginPage(String title) {
        super(title);
        this.setContentPane(loginWindow);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
//        this.setSize(500,500);

        this.currentWindow = this;
        mainDriver = new MainDriver();
        this.fileHandler = new FileHandler();


        adminName = "Admin";
        adminPassword = "abc@123";

//        take this
        MainDriver temp = fileHandler.readFromFle("Shopinfo.txt");
        if (temp != null) {
            this.mainDriver = temp;
        } else {
            this.mainDriver = new MainDriver();
        }


        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPassword = new String(passwordField.getPassword());
                String enteredUserName = userNameField.getText();

                if (enteredUserName.equals(adminName) && enteredPassword.equals(adminPassword)) {
                    JFrame adminLoggin = new AdminView(currentWindow);
                    adminLoggin.setVisible(true);
                    currentWindow.setVisible(false);
                } else {
                    Person loggedinUser = checkLogin(enteredUserName, enteredPassword);
                    if (loggedinUser != null) {
                        if (loggedinUser.getAccessLevel().equals(AccessLevel.CLIENT)) {
                            mainDriver.setCurrentUser(loggedinUser);
                            JFrame shop = new Shop("Shop", currentWindow);
                            shop.setVisible(true);
                            currentWindow.setVisible(false);
                        } else if (loggedinUser.getAccessLevel().equals(AccessLevel.MANAGER)) {
                            mainDriver.setCurrentUser(loggedinUser);
                            JFrame managerView = new ManagerView(currentWindow);
                            managerView.setVisible(true);
                            currentWindow.setVisible(false);
                        } else if (loggedinUser.getAccessLevel().equals(AccessLevel.WORKER)) {
                            mainDriver.setCurrentUser(loggedinUser);
                            JFrame wareHouseManage = new WareHouseManage(currentWindow);
                            wareHouseManage.setVisible(true);
                            currentWindow.setVisible(false);
                        }
                    }
                }

            }
        });
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userReg = new userRegister(currentWindow);
                userReg.setVisible(true);
                currentWindow.setVisible(false);

            }
        });

//        take this
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                fileHandler.writeToFile(mainDriver);
            }
        });


    }

    public Person checkLogin(String userName, String passWord) {

        for (int i = 0; i < mainDriver.getPersonArrayList().size(); i++) {
            mainDriver.getPersonArrayList().get(i).toString();
            if (mainDriver.getPersonArrayList().get(i).getPassword().equals(passWord) &&
                    mainDriver.getPersonArrayList().get(i).getUserName().equals(userName)) {
                JOptionPane.showMessageDialog(loginWindow, "Welcome " + mainDriver.getPersonArrayList().get(i).getFirstName());

                currentWindow.setVisible(false);
                return mainDriver.getPersonArrayList().get(i);
            }
        }
        JOptionPane.showMessageDialog(loginWindow, "Please Register");
        return null;

    }

    public static void main(String[] args) {
        JFrame loginFrame = new LoginPage("LoginWindow");
        loginFrame.setVisible(true);

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
        loginWindow = new JPanel();
        loginWindow.setLayout(new GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        loginWindow.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        loginWindow.add(spacer2, new GridConstraints(1, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-15646442));
        label1.setEnabled(true);
        label1.setText("Welcome");
        loginWindow.add(label1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        loginWindow.add(passwordField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        signUp = new JButton();
        signUp.setText("Client Register");
        loginWindow.add(signUp, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userNameField = new JTextField();
        userNameField.setToolTipText("");
        loginWindow.add(userNameField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        signIn = new JButton();
        signIn.setText("Log In");
        loginWindow.add(signIn, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginWindow;
    }

}
