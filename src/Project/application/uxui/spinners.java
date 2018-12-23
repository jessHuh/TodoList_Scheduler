package Project.application.uxui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;


public class spinners extends JFrame{

    JButton button1;
    JSpinner spinner1, spinner2, spinner3, spinner4;
    String outputString ="";


    public static void main(String[] args) {

        new spinners();
    }

    public spinners(){

        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Jess's Spinners");

        JPanel thePanel = new JPanel();

        // Create a button
        button1 = new JButton("Get Answer");

        ListenForButton lforButton = new ListenForButton();

        button1.addActionListener(lforButton);

        thePanel.add(button1);

        // Spinner1
        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        // Spinner2
        spinner2 = new JSpinner(new SpinnerNumberModel(1,1,100,1));
        thePanel.add(spinner2);

        // Spinner3
        String[] weekDays = {"Mon" , "Tues", "Weds", "Thurs", "Fri"};
        spinner3 = new JSpinner((new SpinnerListModel(weekDays)));
        thePanel.add(spinner3);

        Dimension d = spinner3.getPreferredSize();
        d.width =80;
        spinner3.setPreferredSize(d);


        // Spinner4 - Date
        Date todaysDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todaysDate,null,null,Calendar.DAY_OF_MONTH)); //YEAR MONTH
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);
        thePanel.add(spinner4);

        /*ListenforSpinner lForSpinner = new ListenforSpinner();
        spinner4.addChangeListener(lForSpinner);*/

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){

                outputString += "Spinner1  Vale: " + spinner1.getValue() + "\n";
                outputString += "Spinner2  Vale: " + spinner2.getValue() + "\n";
                outputString += "Spinner3  Vale: " + spinner3.getValue() + "\n";
                outputString += "Spinner4  Vale: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(spinners.this,outputString,"Information",JOptionPane.INFORMATION_MESSAGE );

                outputString ="";


            }
        }
    }

    /*private class ListenforSpinner implements ChangeListener{


        @Override
        public void stateChanged(ChangeEvent e) {

        }
    }*/
}
