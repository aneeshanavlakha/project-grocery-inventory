package ui.pages;

import model.Grocery;
import model.Inventory;

import javax.swing.*;

// Add Grocery page of UI
public class AddGroceryTab extends Tab {
    JTextField name;
    JTextField quantity;
    JTextField minAmount;

    // REQUIRES: inventory from store
    public AddGroceryTab(Inventory inventory) {
        super(inventory);
        setUpPanel();
    }

    // MODIFIES: this panel
    // EFFECTS: sets up add grocery page with text boxes to add grocery name, quantity and minimum amount
    private void setUpPanel() {
        setGroceryName();
        setGroceryQuantity();
        setGroceryMinAmount();
    }

    // MODIFIES: centerpanel
    // EFFECTS: creates a label, and field for user to input name of grocery
    private void setGroceryName() {
        JLabel label1 = new JLabel("Grocery Name:");
        label1.setBounds(10, 20, 200, 25);
        name = new JTextField();
        name.setBounds(200, 20, 165, 25);
        centerPanel.add(label1);
        centerPanel.add(name);
    }

    // MODIFIES: centerpanel
    // EFFECTS: creates a label, and field for user to input quantity of grocery
    private void setGroceryQuantity() {
        JLabel label2 = new JLabel("Grocery Quantity:");
        label2.setBounds(10, 60, 200, 25);
        quantity = new JTextField();
        quantity.setBounds(200, 60, 50, 25);
        centerPanel.add(label2);
        centerPanel.add(quantity);
    }

    // MODIFIES: centerpanel
    // EFFECTS: creates a label, and field for user to input minimum amount of grocery
    private void setGroceryMinAmount() {
        JLabel label3 = new JLabel("Minimum Amount of Grocery:");
        label3.setBounds(10, 100, 200, 25);
        minAmount = new JTextField();
        minAmount.setBounds(200, 100, 50, 25);
        centerPanel.add(label3);
        centerPanel.add(minAmount);
    }

    // MODIFIES: same as super
    // EFFECTS: creates a grocery item with given inputs
    //          if input quantity or min amounts are <0, makes them 0
    //          saves grocery item to inventory
    @Override
    protected void save() {
        String groceryName = name.getText();
        int groceryQuantity = Integer.parseInt(quantity.getText());
        int groceryMinAmount = Integer.parseInt(minAmount.getText());

        if (groceryQuantity < 0) {
            groceryQuantity = 0;
        }

        if (groceryMinAmount < 0) {
            groceryMinAmount = 0;
        }

        Grocery g = new Grocery(groceryName, groceryQuantity, groceryMinAmount);
        inventory.addGrocery(g);

        super.save();
    }
}