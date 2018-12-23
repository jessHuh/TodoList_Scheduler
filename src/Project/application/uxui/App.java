package Project.application.uxui;

import javax.swing.*;

public class App {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame("Jessica's Calendar!");
                frame.setSize(500,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
    }

}
