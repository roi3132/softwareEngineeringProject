package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import prog.AccessLevel;
import prog.Client;
import prog.Gender;
import prog.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class userRegister extends JFrame {
    private JTextField firstName;
    private JTextField lastName;
    private JTextField addressField;
    private JCheckBox femaleCheckBox;
    private JCheckBox maleCheckBox;
    private JTextField email;
    private JTextField userName;
    private JPasswordField newUserPassword;
    private JPasswordField passwordVerification;
    private JButton submit;
    private JButton reset;
    private JPanel panel;
    private JFrame previousWindow;


    public userRegister(JFrame previousWindow) {
        this.previousWindow = previousWindow;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel);
//        this.setLocationRelativeTo(null);
        this.setLocation(500, 200);
        this.pack();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = LoginPage.getMainDriver().getClientArrayList().size() + 1;
                String password1 = new String(passwordVerification.getPassword());
                String password2 = new String(newUserPassword.getPassword());

                if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || addressField.getText().isEmpty() ||
                        email.getText().isEmpty() || userName.getText().isEmpty() || password1.isEmpty() ||
                        password2.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please Fill blank subjects");
                } else if (!password1.equals(password2)) {
                    JOptionPane.showMessageDialog(panel, "Passwords do not match");
                } else if (notAlreadyTakenUserName(userName.getText())) {
                    String fname = firstName.getText();
                    String lname = lastName.getText();

                    Gender gender;
                    if (maleCheckBox.isSelected() && !femaleCheckBox.isSelected()) {
                        gender = Gender.MALE;
                    } else if (!maleCheckBox.isSelected() && femaleCheckBox.isSelected()) {
                        gender = Gender.FEMALE;
                    } else {
                        gender = Gender.NOT_SPECIFIED;
                    }

                    String address = addressField.getText();
                    String useremail = email.getText();
                    String username = userName.getText();
                    Client client = new Client(Integer.toString(id), address, gender, useremail, fname, lname, password1, AccessLevel.CLIENT, username);
                    LoginPage.getMainDriver().getClientArrayList().add(client);
                    LoginPage.getMainDriver().getPersonArrayList().add(client);
                    System.out.println(client.toString());
                    JOptionPane.showMessageDialog(panel, "Registered Successfully");
                }

            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName.setText("");
                lastName.setText("");
                addressField.setText("");
                email.setText("");
                userName.setText("");
                newUserPassword.setText("");
                passwordVerification.setText("");
                maleCheckBox.resetKeyboardActions();
                femaleCheckBox.resetKeyboardActions();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                previousWindow.setVisible(true);
            }
        });
    }

    private void resetFields() {
        firstName.setText("");
        lastName.setText("");
        addressField.setText("");
        email.setText("");
        userName.setText("");
        newUserPassword.setText("");
        passwordVerification.setText("");
        maleCheckBox.setSelected(false);
        femaleCheckBox.setSelected(false);
    }

    private boolean notAlreadyTakenUserName(String newUserName) {

        for (int i = 0; i < LoginPage.getMainDriver().getClientArrayList().size(); i++) {
            if (LoginPage.getMainDriver().getClientArrayList().get(i).getUserName().equals(newUserName)) {
                JOptionPane.showMessageDialog(panel, "User Name Already Taken !");
                return false;
            }
        }
        return true;
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
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("First Name");
        panel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstName = new JTextField();
        firstName.setText("");
        panel.add(firstName, new GridConstraints(0, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Last Name");
        panel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Address");
        panel.add(label3, new GridConstraints(2, 0, 3, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressField = new JTextField();
        panel.add(addressField, new GridConstraints(3, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lastName = new JTextField();
        panel.add(lastName, new GridConstraints(1, 1, 2, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Gender");
        panel.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        femaleCheckBox = new JCheckBox();
        femaleCheckBox.setText("Female");
        panel.add(femaleCheckBox, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Email");
        panel.add(label5, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        email = new JTextField();
        panel.add(email, new GridConstraints(6, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userName = new JTextField();
        panel.add(userName, new GridConstraints(7, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("User Name");
        panel.add(label6, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("New Password");
        panel.add(label7, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newUserPassword = new JPasswordField();
        panel.add(newUserPassword, new GridConstraints(8, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        maleCheckBox = new JCheckBox();
        maleCheckBox.setText("Male");
        panel.add(maleCheckBox, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Enter Password again");
        panel.add(label8, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordVerification = new JPasswordField();
        panel.add(passwordVerification, new GridConstraints(9, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        submit = new JButton();
        submit.setText("Submit");
        panel.add(submit, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reset = new JButton();
        reset.setText("Reset");
        panel.add(reset, new GridConstraints(10, 2, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
