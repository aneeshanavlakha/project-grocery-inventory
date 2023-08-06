package ui.pages;

import model.Grocery;
import model.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Remove grocery page of UI
public class RemoveGroceryTab extends Tab {
    private JTable itemTable;
    private DefaultTableModel tableModel;

    // REQUIRES: inventory from store
    public RemoveGroceryTab(Inventory inventory) {
        super(inventory);
        centerPanel.setLayout(new BorderLayout());
        setUpPanel();
    }

    // MODIFIES: this panel
    // EFFECTS: sets up up-to-date information on inventory value and selection model list
    private void setUpPanel() {
        centerPanel.removeAll();
        setTable();
        makeSelectionModelList();
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // MODIFIES: centerpanel
    // EFFECTS: displays a table with grocery information (name, quantity, minimum amount) and allows for scrolling
    private void setTable() {
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

    // REQUIRES: items are selected from table
    // MODIFIES: tableModel
    // EFFECTS: creates a list of table items users are selecting
    private void makeSelectionModelList() {
        ListSelectionModel selectionModel = itemTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    // MODIFIES: same as super
    // EFFECTS: creates a remove and refresh inventory button that carry out save and refresh
    //          functions respectively
    @Override
    protected void saveButton() {
        saveButton = new JButton("Remove");
        JButton refreshButton = new JButton("Refresh Inventory");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpPanel();
            }
        });

        JPanel buttonRow = formatButtonRow(saveButton);
        buttonRow.add(saveButton);
        buttonRow.add(refreshButton);

        add(buttonRow, BorderLayout.SOUTH);
    }

    // REQUIRES: selection mode list is not empty
    // MODIFIES: selection mode list, centerpanel
    // EFFECTS: removes the groceries present on the selection mode list from inventory
    //          and updates the panel to present refreshed table of groceries
    @Override
    protected void save() {
        List<Grocery> groceries = inventory.getGroceries();
        List<Grocery> newGroc = new ArrayList<>();

        for (int i : itemTable.getSelectedRows()) {
            Grocery grocToAdd = groceries.get(i);
            newGroc.add(grocToAdd);
        }

        for (Grocery g : newGroc) {
            inventory.removeGrocery(g);
        }

        super.save();
        setUpPanel();
    }
}


