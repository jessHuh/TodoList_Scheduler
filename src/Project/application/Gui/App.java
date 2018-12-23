package Project.application.Gui;

import Project.application.Item.ItemManager;
import Project.application.Item.ItemWithDueDate;
import Project.application.function.FileWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    private JButton buttonAdd;
    private JPanel panelMain;
    private JTextField detailTextField;
    private JTextField dueDateTextField;
    private JTextField importanceTextField;
    private JLabel detail;
    private JLabel dueDate;
    private JLabel importance;
    private JTextField tittleTextField;
    private String infoOnComponenet;
    private Project.application.Item.Item item;
    private static Project.application.Item.ItemManager itemManager;
    private static Project.application.function.FileWrite fileWrite = new FileWrite();
    private static String file = "outputItems.txt";

    public App() {
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tittleToString = tittleTextField.getText();
                String detailToString = detailTextField.getText();
                String dueDateToString = dueDateTextField.getText();
                String importanceToString = importanceTextField.getText();
                try {
                    item = new ItemWithDueDate(tittleToString,detailToString,dueDateToString,importanceToString);
                    itemManager.addKey(tittleToString);
                    itemManager.addItem(tittleToString,item);
                    fileWrite.saveItemMap(itemManager,file);
                    infoOnComponenet += item.getItemStr();
                    JOptionPane.showMessageDialog(null, item.getItemStr());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jess Calendar");
        frame.setContentPane(new App().panelMain);
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        itemManager = new ItemManager();
        try {
            fileWrite.load(file, itemManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new App();
    }
}
