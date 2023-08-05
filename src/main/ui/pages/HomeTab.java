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
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JButton loadButton;
    private GroceryInventoryUI gui;


    public HomeTab(Inventory inventory, GroceryInventoryUI gui) {
        super(inventory);
        this.gui = gui;
        centerPanel.setLayout(new BorderLayout());
        setPage(inventory);
        loadButton();
    }

    private void setPage(Inventory inventory) {
        centerPanel.removeAll();
        displayValue(inventory);
        loadTable(inventory);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(heading, BorderLayout.NORTH);
    }

    private void loadTable(Inventory inventory) {
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

    //Load button that reloads inventory once updated
    private void loadButton() {
        loadButton = new JButton("Load Inventory");
        this.add(loadButton, BorderLayout.SOUTH);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.loadInventory();    //not reloading updated inventory on click
                setPage(inventory);
            }
        });
    }
}

// bordered heading "My inventory"
// subheading with value displayed
// jtable that has 3 separate columns for name, qty and minamount
// table updates as things are added to the inventory ie whenever save is hit in other tabs
// reload button loads all values in inventory