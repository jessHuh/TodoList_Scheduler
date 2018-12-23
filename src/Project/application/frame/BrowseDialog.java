package Project.application.frame;

import Item.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import static frame.MainFrame.itemManager;


public class BrowseDialog extends JDialog implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu,submenu;
    private JMenuItem study,career,chore,event, browseAll, importantMenu;
    //private JCheckBoxMenuItem importantCheckMenu;
    
    private JPanel tablePanel;
    private final String[] columnIndex = {"Tittle","Detail","Due Date","Important?"};
    private DefaultTableModel defaultTableModel = new DefaultTableModel(columnIndex,0);
    private JTable table;
    private JScrollPane scrollPane;

    public BrowseDialog(){
        setLayout(null);
        setUpDialog();
    }

    private void setUpDialog() {

        // create a menu bar
        menuBar = new JMenuBar();


        // Part1. build the menu
        menu = new JMenu("Browse");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);

        // group of menu items
        // (1) browse all
        browseAll = new JMenuItem("Browse all");
        menu.add(browseAll);
        browseAll.addActionListener(this);


        // (2) browse only Important one
        menu.addSeparator();
        importantMenu = new JMenuItem("Browse important items");
        menu.add(importantMenu);
        importantMenu.addActionListener(this);

        // (3) browse by tittles
        menu.addSeparator();
        submenu = new JMenu("Browse by tittles");
        submenu.setMnemonic(KeyEvent.VK_S);

        study = new JMenuItem("Study");
        submenu.add(study);
        study.addActionListener(this);

        career = new JMenuItem("Career");
        submenu.add(career);
        career.addActionListener(this);

        event = new JMenuItem("Event");
        submenu.add(event);
        event.addActionListener(this);

        chore = new JMenuItem("Chore");
        submenu.add(chore);
        chore.addActionListener(this);

        menu.add(submenu);
        
        this.setJMenuBar(menuBar);

        // Part2 : tablePanel
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(0,0,450,300);
        add(tablePanel);
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        scrollPane.setBounds(0,0,450,300);

        DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
        tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcmSchedule = table.getColumnModel();
        for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
            if(!(i ==1)) {
                tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
            }
        }
    }

    public void update(Set<String> keyset){
        if (defaultTableModel != null) defaultTableModel.getDataVector().removeAllElements();
        Set<String> keySet = keyset;
        for(String key : keySet){
            for(Item item : itemManager.getItemMap().get(key)){
                Object[] data = new Object[4];
                data[0] = item.getTittle();
                data[1] = item.getDetail();
                data[2] = item.getDueDate();
                data[3] = item.getImportance();
                defaultTableModel.addRow(data);
            }
        }
    }

    public void browseImportantItem(){
        if (defaultTableModel != null) defaultTableModel.getDataVector().removeAllElements();
        for(Item item : itemManager.getImportantItemList()){
            Object[] data = new Object[4];
            data[0] = item.getTittle();
            data[1] = item.getDetail();
            data[2] = item.getDueDate();
            data[3] = item.getImportance();
            defaultTableModel.addRow(data);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(browseAll == e.getSource()){
            Set<String> keySet = itemManager.getKey();
            update(keySet);
        }
        if(importantMenu == e.getSource()){
            browseImportantItem();
        }

        if(study == e.getSource()){
            Set<String> keyset = new HashSet<>();
            keyset.add("Study");
            update(keyset);

        }
        if(chore == e.getSource()){
            Set<String> keyset = new HashSet<>();
            keyset.add("Chore");
            update(keyset);
        }

        if(event == e.getSource()){
            Set<String> keyset = new HashSet<>();
            keyset.add("Event");
            update(keyset);
        }
        if(career == e.getSource()) {
            Set<String> keyset = new HashSet<>();
            keyset.add("Career");
            update(keyset);
        }

    }
}
