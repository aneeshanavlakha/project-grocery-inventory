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

        setLayout(new BorderLayout());

        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);

        loadTable(inventory);
        loadButton();
    }

    private void loadTable(Inventory inventory) {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Minimum Amount"}, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        add(scrollPane, BorderLayout.CENTER);
        for (Grocery grocery : inventory.getGroceries()) {
            tableModel.addRow(new Object[]
                    {grocery.getGroceryName(), grocery.getQuantity(), grocery.getMinAmount()});
        }
        add(scrollPane, BorderLayout.CENTER);
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

// bordered heading "My inventory"
// subheading with value displayed
// jtable that has 3 separate columns for name, qty and minamount
// table updates as things are added to the inventory ie whenever save is hit in other tabs
// reload button loads all values in inventory