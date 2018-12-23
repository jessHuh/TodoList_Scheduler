package Project.application.uxui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private DetailsPanel detailsPanel;

    public MainFrame(String tittle){
        super(tittle);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing component
        final JTextArea textArea = new JTextArea();
        //JScrollPane scrollBar = new JScrollPane(textArea,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        //JButton button = new JButton("Click me!");

        detailsPanel =  new DetailsPanel();

        //detailsPanel.add(scrollBar);


        detailsPanel.addDetailListener(new DetailListener(){
            public void detailEvenOccured(DetailEvent event){
                String text = event.getText();

                textArea.append(text);

            }
        });


        // Add Swing component to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        //c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.WEST);


        /*// Add behavior
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello\n");
            }
        });*/
    }
}
