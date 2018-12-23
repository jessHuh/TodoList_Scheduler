package Project.application.uxui;

import javax.swing.*;
import java.awt.*;

public class gridLayout extends JFrame{

    JButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butPlus, butMinus, clearAll;

    JTextField textResults;

    public static void main(String[] args) {
        new gridLayout();
    }

    public gridLayout(){

        // Create the frame, position and handle closing it

        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Layout format!");

        JPanel thePanel = new JPanel();

        /* Grid Layout

        thePanel.setLayout(new GridLayout(0,3,2,2));

        but1 = new JButton("1");
        but2 = new JButton("2");
        but3 = new JButton("3");
        but4 = new JButton("4");
        but5 = new JButton("5");
        but6 = new JButton("6");
        but7 = new JButton("7");
        but8 = new JButton("8");
        but9 = new JButton("9");
        butPlus = new JButton("+");
        butMinus = new JButton("-");
        clearAll = new JButton("0");

        thePanel.add(but1);
        thePanel.add(but2);
        thePanel.add(but3);
        thePanel.add(but4);
        thePanel.add(but5);
        thePanel.add(but6);
        thePanel.add(but7);
        thePanel.add(but8);
        thePanel.add(but9);
        thePanel.add(butPlus);
        thePanel.add(butMinus);
        thePanel.add(clearAll);
        */

        // GridBagLayout
        thePanel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;

        textResults = new JTextField("0",20);

        Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResults.setFont(font);

        but1 = new JButton("1");
        but2 = new JButton("2");
        but3 = new JButton("3");
        but4 = new JButton("4");
        but5 = new JButton("5");
        but6 = new JButton("6");
        but7 = new JButton("7");
        but8 = new JButton("8");
        but9 = new JButton("9");
        but0 = new JButton("0");
        butPlus = new JButton("+");
        butMinus = new JButton("-");
        clearAll = new JButton("C");

        thePanel.add(clearAll,gridConstraints);
        gridConstraints.gridwidth = 20;
        gridConstraints.gridx = 5;

        thePanel.add(textResults,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy =2;

        thePanel.add(but1,gridConstraints);
        gridConstraints.gridx =5;

        thePanel.add(but2,gridConstraints);
        gridConstraints.gridx =9;

        thePanel.add(but3,gridConstraints);
        gridConstraints.gridx =1;
        gridConstraints.gridy =3;
        thePanel.add(but4,gridConstraints);
        gridConstraints.gridx =5;
        thePanel.add(but5,gridConstraints);
        gridConstraints.gridx =9;
        thePanel.add(but6,gridConstraints);
        gridConstraints.gridx =1;
        gridConstraints.gridy =4;
        thePanel.add(but7,gridConstraints);
        gridConstraints.gridx =5;
        thePanel.add(but8,gridConstraints);
        gridConstraints.gridx =9;
        thePanel.add(but9,gridConstraints);
        gridConstraints.gridx =1;
        gridConstraints.gridy =5;
        thePanel.add(butPlus,gridConstraints);
        gridConstraints.gridx =5;
        thePanel.add(but0,gridConstraints);
        gridConstraints.gridx =9;
        thePanel.add(butMinus,gridConstraints);


        this.add(thePanel);
        this.setVisible(true);
    }

}
