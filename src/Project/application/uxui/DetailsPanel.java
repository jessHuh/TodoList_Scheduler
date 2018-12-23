package Project.application.uxui;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel {

    private EventListenerList listenerList = new EventListenerList();

    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLabel = new JLabel("Name:   ");
        JLabel occupationLabel = new JLabel("Occupation:   ");

        final JTextField nameField = new JTextField(10);
        final JTextField occupationField = new JTextField(10);

        //nameLabel.setToolTipText("Enter the name");
        //nameField.setToolTipText("Enter the occupation");

        JButton addBtn = new JButton("Add");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();

                String text = name + " : " + occupation + "\n";

                fireDetailEvent(new DetailEvent(this, text));

            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First Column ///////////////

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(occupationLabel, gc);

        //// Second Column //////////////

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(occupationField, gc);


        //// Final Row ////////////////
        // gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 10;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);
    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = listenerList.getListenerList();

        for(int i=0; i<listeners.length; i +=2){
            if(listeners[i] == DetailListener.class){
                ((DetailListener)listeners[i+1]).detailEvenOccured(event);
            }
        }
    }
    public void addDetailListener(DetailListener listner){
        listenerList.add(DetailListener.class, listner);

    }
    public void removeDetailListener(DetailListener listner){
        listenerList.remove(DetailListener.class, listner);

    }

}

