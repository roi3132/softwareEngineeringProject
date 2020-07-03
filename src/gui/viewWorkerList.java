package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import prog.Client;
import prog.Person;
import prog.Product;
import prog.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class viewWorkerList extends JFrame {
    private JPanel mainPanel;
    private JList currentWorkerList;
    private JButton moveToSelectedButton;
    private JButton removeWorkerButton;
    private JFrame previousWindow;
    private JFrame currentWindow;
    ArrayList<Worker> workerArrayList;

    public viewWorkerList(JFrame previousWindow) {
        this.previousWindow = previousWindow;
        this.currentWindow = this;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
//        this.setLocationRelativeTo(null);
        this.setLocation(300, 200);
        this.setSize(750, 300);
        this.currentWorkerList.setFont(new Font("monospaced", Font.PLAIN, 12));

        setWorkers();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                previousWindow.setVisible(true);
            }
        });


        removeWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To remove selected worker
                String selectedWorker = (String) currentWorkerList.getSelectedValue();
                System.out.println(selectedWorker);

                Worker selectedWorkerObject = getSelectedObject(selectedWorker, LoginPage.getMainDriver().getWorkerArrayList());

                int mainIndex = LoginPage.getMainDriver().getWorkerArrayList().indexOf(selectedWorkerObject);
                LoginPage.getMainDriver().getWorkerArrayList().remove(mainIndex);

                int index = LoginPage.getMainDriver().getPersonArrayList().indexOf(selectedWorkerObject);
                LoginPage.getMainDriver().getPersonArrayList().remove(index);

                setWorkers();
            }
        });
    }

    private void setWorkers() {
        workerArrayList = LoginPage.getMainDriver().getWorkerArrayList();
        Vector<String> workerList = new Vector<String>();

//        for (int i = 0; i < LoginPage.getMainDriver().getWorkerArrayList().size(); i++) {
//            workerList.addElement("Worker id: " + LoginPage.getMainDriver().getWorkerArrayList().get(i).getId() +
//                    " Worker name: " + LoginPage.getMainDriver().getWorkerArrayList().get(i).getFirstName() + " " +
//                    LoginPage.getMainDriver().getWorkerArrayList().get(i).getLastName());
//        }

        for (int i = 0; i < LoginPage.getMainDriver().getWorkerArrayList().size(); i++) {
            workerList.addElement(LoginPage.getMainDriver().getWorkerArrayList().get(i).toString());
        }


        currentWorkerList.setListData(workerList);
    }

    private Worker getSelectedObject(String stringFromVector, ArrayList<Worker> workerArrayList) {
        for (int i = 0; i < workerArrayList.size(); i++) {

            if (workerArrayList.get(i).toString().equals(stringFromVector)) {

                return workerArrayList.get(i);

            }
        }
        return null;

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
        mainPanel.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(mainPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        currentWorkerList = new JList();
        mainPanel.add(currentWorkerList, new GridConstraints(1, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Current Worker List");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeWorkerButton = new JButton();
        removeWorkerButton.setText("Remove Worker");
        mainPanel.add(removeWorkerButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
