package ui.pages;

import model.Grocery;
import model.Inventory;
import ui.GroceryInventoryUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Home page of UI
public class HomeTab extends Tab {
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JButton loadButton;
    private GroceryInventoryUI gui;


    // REQUIRES: inventory from store, access to grocery inventory fields
    public HomeTab(Inventory inventory, GroceryInventoryUI gui) {
        super(inventory);
        this.gui = gui;
        centerPanel.setLayout(new BorderLayout());
        setUpPanel(inventory);
        loadButton();
    }

    // MODIFIES: this panel
    // EFFECTS: refreshes this panel to display up-to-date information on inventory value and grocery table
    private void setUpPanel(Inventory inventory) {
        centerPanel.removeAll();
        displayValue(inventory);
        setTable(inventory);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // EFFECTS: displays the value from inventory at the top of the panel
    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(heading, BorderLayout.NORTH);
    }

    // MODIFIES: centerpanel
    // EFFECTS: displays a table with grocery information (name, quantity, minimum amount) and allows for scrolling
    private void setTable(Inventory inventory) {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Minimum Amount"}, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        for (Grocery grocery : inventory.getGroceries()) {
            tableModel.addRow(new Object[]
                    {grocery.getGroceryName(), grocery.getQuantity(), grocery.getMinAmount()});
        }
        centerPanel.add(scrollPane, BorderLayout.CENTER);
    }

    // Based on LongFormProblemStarters>SmartHome>UI>SettingsTab
    // https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters/blob/
    //                       ad73576d8c962430983dc95cca9a0344760b3679/SmartHome/src/main/ui/tabs/SettingsTab.java
    // MODIFIES: this
    // EFFECTS: load button that refreshes inventory to display any changes
    private void loadButton() {
        loadButton = new JButton("Refresh Inventory");
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        JPanel buttonRow = formatButtonRow(loadButton);
        buttonRow.add(addButton);
        buttonRow.add(removeButton);

        buttonActionListeners(addButton, removeButton);

        add(buttonRow, BorderLayout.SOUTH);
    }

    // MODIFIES: loadButton, addButton and removeButton
    // EFFECTS: defines action events for the 3 buttons on the home page
    private void buttonActionListeners(JButton addButton, JButton removeButton) {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.loadInventory();
                setUpPanel(inventory);
            }
        });

        addButton.addActionListener(e -> {
            gui.getPane().setSelectedIndex(1);
        });

        removeButton.addActionListener(e -> {
            gui.getPane().setSelectedIndex(2);
        });
    }

}
