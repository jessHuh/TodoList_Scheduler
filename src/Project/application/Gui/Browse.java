package Project.application.Gui;

import Project.application.Item.Item;
import Project.application.Item.ItemManager;
import Project.application.function.FileWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Browse {
    private static JFrame frame;
    private JPanel browsePanel;
    //private JTextArea PrintOutItem;
    private JButton buttonAll;
    private JComboBox keyOfList;
    private JButton buttonforList;
    private JComboBox importance;
    private JButton buttonImportance;
    private JLabel browseAll;
    private JLabel browseByList;
    private JLabel browsebyImportance;
    private JTextArea PrintOutItem;
    private Item item;
    private static ItemManager itemManager;
    private static FileWrite fileWrite = new FileWrite();
    private static String file = "outputItems.txt";
    private String text = "";
    private static Map<String, ArrayList<Item>>itemMap;

    public Browse() {
        //JScrollPane scroll = new JScrollPane (PrintOutItem,
        //        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        PrintOutItem.setLineWrap(true);
        PrintOutItem.setWrapStyleWord(true);


        //Set<String> keySet = itemManager.getKey();
        //for(String key : keySet){
        //    keyOfList.addItem(key);
        //}
        String[] tittles = {"Study", "Career", "Event", "Chore"};
        keyOfList.addItem("yyy");

        buttonAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<String> keySet = itemManager.getKey();
                for (String key : keySet) {
                    keyOfList.addItem(key);
                    PrintOutItem.append("\n [ Tittle : " + key + " ]\n");
                    for (Item item : itemMap.get(key)) {
                        String detail = item.getDetail();
                        String dueDate = item.getDueDate();
                        String importance = item.getImportance();
                        PrintOutItem.append("Detail : " + detail + "\n");
                        PrintOutItem.append("Due Date : " + dueDate + "\n");
                        PrintOutItem.append("Important? : " + importance + "\n\n");
                    }
                }
            }
        });

        buttonImportance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Item> importantItemList = itemManager.getImportantItemList();
                PrintOutItem.append("\n [ Only Important Items ] \n");
                for(Item item : importantItemList){
                    if(item.getImportance().equals("yes")){
                        String title = item.getTittle();
                        String detail = item.getDetail();
                        String dueDate = item.getDueDate();
                        PrintOutItem.append("Tittle : " + title + "\n");
                        PrintOutItem.append("Detail : " + detail + "\n");
                        PrintOutItem.append("Due Date : " + dueDate + "\n\n");
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        frame = new JFrame("Jess Calendar");
        frame.setContentPane(new Browse().browsePanel);
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        itemManager = new ItemManager();

        try {
            fileWrite.load(file, itemManager);
            itemMap = itemManager.getItemMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new Browse();
    }
}
