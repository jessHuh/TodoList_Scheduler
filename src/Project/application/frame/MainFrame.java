package Project.application.frame;

import Project.application.Item.ItemManager;
import Project.application.function.FileWrite;
import function.Holiday;
import function.ReadWebPageJson;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private final Rectangle MAIN_FRAME_RECT = new Rectangle(100, 100, 700, 400);
    private final Rectangle BUTTON_PANEL_RECT = new Rectangle(0, 0, MAIN_FRAME_RECT.width, (int)(MAIN_FRAME_RECT.height * 0.2));

    private final int CALENDAR_PANEL_Y = BUTTON_PANEL_RECT.height;
    private final int CALENDAR_PANEL_WIDTH = (int)(MAIN_FRAME_RECT.width*0.4);
    private final int CALENDAR_PANEL_HEIGHT = (int)(MAIN_FRAME_RECT.height - BUTTON_PANEL_RECT.height);
    private final Rectangle CALENDAR_PANEL_RECT = new Rectangle(0, CALENDAR_PANEL_Y, CALENDAR_PANEL_WIDTH, CALENDAR_PANEL_HEIGHT);

    private final int BUTTON_PANEL_X = CALENDAR_PANEL_WIDTH;
    private final int BUTTON_PANEL_Y = CALENDAR_PANEL_Y;
    private final int BUTTON_PANEL_WIDTH = (int)(MAIN_FRAME_RECT.width*0.6);
    private final int BUTTON_PANEL_HEIGHT = (int)(MAIN_FRAME_RECT.height - BUTTON_PANEL_RECT.height);

    private final Rectangle TABLE_PANEL_RECT = new Rectangle(BUTTON_PANEL_X,BUTTON_PANEL_Y,BUTTON_PANEL_WIDTH,BUTTON_PANEL_HEIGHT);

    private JPanel buttonPanel, tablePanel, calendarPanel;
    private JButton browseButton, addButton, editButton, deleteButton;
    private AddDialog addDialog;
    private BrowseDialog browseDialog;
    public static ItemManager itemManager;
    public static FileWrite fileWrite;
    private static String file = "outputItems.txt";
    private String[] images = new String[11];
    private JTable table;
    private final String[] columnIndex = {"Date","Holiday"};
    private DefaultTableModel defaultTableModel = new DefaultTableModel(columnIndex,0);
    private JScrollPane scrollPane;
    ReadWebPageJson holiday = new ReadWebPageJson();

    public void start() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jessica's Todo List");
        setBounds(MAIN_FRAME_RECT);
        setLayout(null);

        buttonPanel = new JPanel();
        calendarPanel = new JPanel();
        tablePanel = new JPanel();

        buttonPanel.setBounds(BUTTON_PANEL_RECT);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        calendarPanel.setBounds(CALENDAR_PANEL_RECT);
        //calendarPanel.setLayout(null);
        tablePanel.setBounds(TABLE_PANEL_RECT);
        tablePanel.setLayout(null);

        //setting table
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        scrollPane.setBounds(0,0,400,250);


        DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
        tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcmSchedule = table.getColumnModel();
        for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
            if(!(i ==1)) {
                tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
            }
        }

        if (defaultTableModel != null) defaultTableModel.getDataVector().removeAllElements();
        for(Holiday holiday : holiday.getHolidayList()){
            Object[] data = new Object[2];
            data[0] = holiday.getDate();
            data[1] = holiday.getHoliday();
            defaultTableModel.addRow(data);
        }


        add(buttonPanel);
        add(calendarPanel);
        add(tablePanel);

        browseButton = new JButton("Browse");
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        addButton.addActionListener(this);
        browseButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        buttonPanel.add(browseButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);


        // image saving
        int i;
        for(i =0; i <=10; i++){
            images[i] = i+".png";
        }

        // image setting/appear
        String image = images[(int) (Math.random()*images.length)];
        BufferedImage myPicture = ImageIO.read(this.getClass().getResource(image));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        calendarPanel.add(picLabel);


        // button setting
        addButton.setSize(80, 20);
        editButton.setSize(80, 20);
        deleteButton.setSize(80, 20);
        setVisible(true);




    }

    public static void main(String[] args) throws IOException {
        itemManager = new ItemManager();
        fileWrite = new FileWrite();
        fileWrite.load(file, itemManager);
        MainFrame mainFrame = new MainFrame();
        mainFrame.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (addButton == e.getSource()){
            addDialog = new AddDialog();
            showAddDialogGUI();
        }
        if (browseButton == e.getSource()){
            browseDialog = new BrowseDialog();
            showBrowseDialogGUI();

        }
        if(editButton == e.getSource()){
            JOptionPane.showMessageDialog(null, "Oops, sorry we will implement it ASAP!!", "Construction", 1);
        }

        if(deleteButton == e.getSource()){
            JOptionPane.showMessageDialog(null, "Oops, sorry we will implement it ASAP!!", "Construction", 1);
        }
    }

    private void showBrowseDialogGUI() {
        browseDialog.setBounds(200,200,450,350);
        browseDialog.setVisible(true);
    }

    private void showAddDialogGUI() {
        // TODO: change location??
        addDialog.setBounds(200,200,300,200);
        addDialog.setVisible(true);
    }

}
