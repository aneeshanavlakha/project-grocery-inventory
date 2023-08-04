package ui.pages;

import model.Grocery;
import model.Inventory;
import ui.GroceryInventoryUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeTab extends Tab {
    private static final String HEADING = "My Inventory";
    private static final String VALUE = "Value: ";

    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JButton loadButton;
    private GroceryInventoryUI giUI;


    public HomeTab(Inventory inventory, GroceryInventoryUI gui) {
        super(inventory);
        this.giUI = gui;

        // Set the layout for the panel
        setLayout(new BorderLayout());
        // Create the table model with column names and 0 rows initially
        tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Price"}, 0);
        // Create the JTable with the custom table model
        itemTable = new JTable(tableModel);
        // Add the JTable to a scroll pane to enable scrolling if needed
        JScrollPane scrollPane = new JScrollPane(itemTable);
        // Add the scroll pane to the panel's center
        add(scrollPane, BorderLayout.CENTER);
        // Add some sample data to the table
        for (Grocery grocery : inventory.getGroceries()) {
            tableModel.addRow(new Object[]
                    {grocery.getGroceryName(), grocery.getQuantity(), grocery.getMinAmount()});
        }

        loadButton();

    }

    //Load button that reloads inventory once updated
    private void loadButton() {
        loadButton = new JButton("Load Inventory");
        this.add(loadButton, BorderLayout.SOUTH);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giUI.loadInventory();    //not reloading updated inventory on click
            }
        });
    }
}

// bordered heading
// jtable that has 3 separate columns for name, qty and minamount
// table updates as things are added to the inventory ie whenever save is hit in other tabs
// reload button loads all values in inventory