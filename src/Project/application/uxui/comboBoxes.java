package Project.application.uxui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class comboBoxes extends JFrame {

    JComboBox tittleOfLists;
    JButton button1;
    String infoOnComponent="";

    public static void main(String[] args){
        new comboBoxes();

    }

    public comboBoxes(){
        this.setSize(400,400);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Add Item");

        JPanel thePanel = new JPanel();

        String[] tittles = {"Study", "Career", "Event", "Chore"};

        tittleOfLists = new JComboBox(tittles);

        tittleOfLists.addItem("I HAVE TO MAKE IT!!");

        thePanel.add(tittleOfLists);

        button1 = new JButton("Add Item");

        ListenForButtons lForButton = new ListenForButtons();

        button1.addActionListener(lForButton);

        thePanel.add(button1);

        this.add(thePanel);
        this.setVisible(true);

        tittleOfLists.insertItemAt("INSERT NEW ITEM HERE",1);
        tittleOfLists.setMaximumRowCount(3);
        tittleOfLists.removeItem("INSERT NEW ITEM HERE");
        tittleOfLists.removeItemAt(1);

    }

    private class ListenForButtons implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == button1){

                tittleOfLists.setEditable(true);

                infoOnComponent += "Item at 0: " + tittleOfLists.getItemAt(0) + "\n";
                infoOnComponent += "Num of Lists: " + tittleOfLists.getItemCount() + "\n";
                infoOnComponent += "Selected ID: " + tittleOfLists.getSelectedIndex() + "\n";
                infoOnComponent += "Selected List: " + tittleOfLists.getSelectedItem() + "\n";
                infoOnComponent += "Are Editable: " + tittleOfLists.isEditable() + "\n";

                JOptionPane.showMessageDialog(comboBoxes.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);

                infoOnComponent = "";
            }

        }
    }
}
