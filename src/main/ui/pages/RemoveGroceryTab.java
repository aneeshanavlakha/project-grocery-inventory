package ui.pages;

import model.Grocery;
import model.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class RemoveGroceryTab extends Tab {
    private JTable itemTable;
    private DefaultTableModel tableModel;


    public RemoveGroceryTab(Inventory inventory) {
        super(inventory);
        centerPanel.setLayout(new BorderLayout());
        setUpPanel();
    }

    // EFFECTS: !!
    public void setUpPanel() {
        centerPanel.removeAll();
        JScrollPane scrollPane = setTable();
        makeSelectionModelList();
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void makeSelectionModelList() {
        ListSelectionModel selectionModel = itemTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private JScrollPane setTable() {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Minimum Amount"}, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        for (Grocery grocery : inventory.getGroceries()) {
            tableModel.addRow(new Object[]
                    {grocery.getGroceryName(), grocery.getQuantity(), grocery.getMinAmount()});
        }
        return scrollPane;
    }

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
// drop down menu with names of all current groceries
// when user selects a grocery and hits "save", grocery item is
// removed from inventory and changes reflect on home page

