package Project.application.uxui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listComponent extends JFrame{

    JButton button1;
    String infoOnComponent = "";
    JList tittleOfLists;
    JList items;
    DefaultListModel defListModel = new DefaultListModel();
    JScrollPane scoller;

    public static void main(String[] args) {
        new listComponent();
    }

    public listComponent(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel thePanel = new JPanel();
        button1 = new JButton("Add Item");

        ListenForButton lForbutton = new ListenForButton();

        button1.addActionListener(lForbutton);

        thePanel.add(button1);

        String[] tittles = {"Study", "Career" , "Event", "Chore"};

        tittleOfLists = new JList(tittles);
        tittleOfLists.setFixedCellHeight(30);
        tittleOfLists.setFixedCellWidth(150);
        tittleOfLists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String[] item = {"CPSC 210", "CPSC 121", "CPSC 302", "MATH 200"};

        for(String i: item){
            defListModel.addElement(i);
        }

        defListModel.add(2, "CPSC 310");

        items = new JList(defListModel);

        items.setVisibleRowCount(4);

        scoller = new JScrollPane(items,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        items.setFixedCellHeight(30);
        items.setFixedCellWidth(150);

        thePanel.add(tittleOfLists);
        thePanel.add(scoller);

        this.add(thePanel);
        this.setVisible(true);

    }

    private class ListenForButton implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){

                if(defListModel.contains("CPSC 210")) infoOnComponent+= "CPSC 210 is HERE!!" + "\n";

                if(!defListModel.isEmpty()) infoOnComponent+= "The List is not EMPTY" + "\n";

                infoOnComponent += "Element in the List" + defListModel.size() + "\n";

                infoOnComponent += "Last Element" + defListModel.lastElement() + "\n";

                infoOnComponent += "First Element" + defListModel.firstElement() + "\n";

                infoOnComponent += "In Index 1 " + defListModel.get(1) + "\n";

                defListModel.remove(0);
                defListModel.removeElement("CPSC 121");

                Object[] arrayOfList = defListModel.toArray();
                for(Object item : arrayOfList){
                    infoOnComponent += item + "\n";
                }

                JOptionPane.showMessageDialog(listComponent.this,infoOnComponent,"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }



}
