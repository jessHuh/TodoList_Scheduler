package Project.application.frame;


import Item.ItemWithDueDate;
import Item.ItemWithoutDueDate;
import Project.application.Item.Item;
import exception.notValidException;
import exception.tooLongException;
import exception.useCommaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static frame.MainFrame.itemManager;

public class AddDialog extends JDialog{
    private final String[] titles = {"Study", "Career", "Event", "Chore"};
    private JLabel titleLabel, detailLabel, dueDateLabel, importantLabel;
    private JButton addButton;
    private JComboBox tittleComboBox;
    private JTextField detailTextField, dueDateTextField;
    private JCheckBox importantCheckBox;
    private Item item;

    public AddDialog(){

        setLayout(null);
        setUpDialog();
    }

    private void setUpDialog() {
        setTitle("Let's add a new item!");

        titleLabel = new JLabel("Tittle");
        titleLabel.setBounds(10,0,100,25);
        add(titleLabel);

        detailLabel = new JLabel("Detail");
        add(detailLabel);
        detailLabel.setBounds(10,40,100,25);

        dueDateLabel = new JLabel("Due Date");
        add(dueDateLabel);
        dueDateLabel.setBounds(10,80,100,25);

        importantLabel = new JLabel("Important");
        add(importantLabel);
        importantLabel.setBounds(10,120,100,25);


        addButton = new JButton("Add");
        add(addButton);
        addButton.setBounds(70,150,150,30);


        tittleComboBox = new JComboBox(titles);
        tittleComboBox.setBounds(100, 0,200,30);
        add(tittleComboBox);

        detailTextField = new JTextField();
        detailTextField.setBounds(100,40,200,30);
        add(detailTextField);

        dueDateTextField = new JTextField();
        dueDateTextField.setBounds(100,80,200,30);
        add(dueDateTextField);

        importantCheckBox = new JCheckBox();
        add(importantCheckBox);
        importantCheckBox.setBounds(100,120,80,20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addFunc();
                } catch (notValidException e1) {
                    JOptionPane.showMessageDialog(null, "You either used comma or input too long details! \n Let's try it again!", "Invalid Detail", 0);
                }


            }

            private void addFunc() throws useCommaException, tooLongException {
                String title = tittleComboBox.getSelectedItem().toString();
                String detail = detailTextField.getText();
                String dueDate = dueDateTextField.getText();
                Boolean importance = importantCheckBox.isSelected();
                String importanceString = "yes";
                if(!importance){ importanceString = "no";}


                // Change date format
                String dueDateFormatted;

                // (1) No due date case
                if(dueDate.isEmpty()){
                    dueDateFormatted = "NO DUE DATE";
                }
                // (2) Due date case
                else{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
                    Calendar date = Calendar.getInstance();
                    String year = dueDate.substring(0,4);
                    String month = dueDate.substring(4,6);
                    String day = dueDate.substring(6,8);
                    date.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
                    dueDateFormatted = sdf.format(date.getTime());
                }

                // throw invalid exceptions
                if(detail.contains(",")){
                    throw new useCommaException();
                }
                if(detail.length()>100){
                    throw new tooLongException();
                }

                // make a new item
                try {
                    if(dueDateFormatted.equals("NO DUE DATE")){
                        item = new ItemWithoutDueDate(title, detail, dueDateFormatted, importanceString);
                    }
                    else{
                        item = new ItemWithDueDate(title, detail, dueDateFormatted, importanceString);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // add a new item to itemManager
                try {
                    itemManager.addItem(title, item);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                // close the dialog
                dispose();
            }
        });

    }

}
