package ui.pages;

import model.Grocery;
import model.Inventory;
import javax.swing.*;

// Add grocery page of UI
public class AddGroceryTab extends Tab {
    JTextField name;
    JTextField quantity;
    JTextField minAmount;

    // REQUIRES: inventory from store
    public AddGroceryTab(Inventory inventory) {
        super(inventory);
        setUpPanel();
    }

    // MODIFIES: centerpanel
    // EFFECTS: sets up add grocery page with text boxes to add grocery name, quantity and minimum amount
    private void setUpPanel() {
        setGroceryName();
        setGroceryQuantity();
        setGroceryMinAmount();
    }

    // REQUIRES: input can be only a String
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

    // REQUIRES: input must be >= 0
    // MODIFIES: centerpanel
    // EFFECTS: creates a label, and field for user to input quantity of grocery
    private void setGroceryQuantity() {
        JLabel label2 = new JLabel("Grocery Quantity:");
        label2.setBounds(10, 60, 200, 25);
        quantity = new JTextField();
        quantity.setBounds(200, 60, 50, 25);
        // do not allow negative numbers!!
        centerPanel.add(label2);
        centerPanel.add(quantity);
    }

    // REQUIRES: input must be >= 0
    // MODIFIES: centerpanel
    // EFFECTS: creates a label, and field for user to input minimum amount of grocery
    private void setGroceryMinAmount() {
        JLabel label3 = new JLabel("Minimum Amount of Grocery:");
        label3.setBounds(10, 100, 200, 25);
        minAmount = new JTextField();
        minAmount.setBounds(200, 100, 50, 25);
        // do not allow negative numbers!!
        centerPanel.add(label3);
        centerPanel.add(minAmount);
    }

    // REQUIRES: valid inputs are made in the input fields
    // MODIFIES: same as super
    // EFFECTS: saves inputs as values required to run super (save inputs to store)
    @Override
    protected void save() {
        Grocery g = new Grocery(name.getText(), Integer.parseInt(quantity.getText()),
                Integer.parseInt(minAmount.getText()));
        inventory.addGrocery(g);
        super.save();
    }
}