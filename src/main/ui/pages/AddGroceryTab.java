package ui.pages;

import model.Grocery;
import model.Inventory;
import ui.GroceryInventoryUI;

import javax.swing.*;
import java.awt.*;

public class AddGroceryTab extends Tab {
    JTextField name;
    JTextField quantity;
    JTextField minAmount;

    public AddGroceryTab(Inventory inventory) {
        super(inventory);
        this.setLayout(super.getLayout());
        // quantity text box not showing up
        // allows you to add text in random point on page
        // sometimes setuppanel only shows up when you click the page
        setUpPanel();
    }

    // EFFECTS: sets up add grocery page with text boxes to add grocery name, quantity and minamount, and
    //          save button
    public void setUpPanel() {
        JLabel label1 = new JLabel("Grocery Name:");
        label1.setBounds(10, 20, 200, 25);
        name = new JTextField();
        name.setBounds(200, 20, 165, 25);
        add(label1);
        add(name);

        JLabel label2 = new JLabel("Grocery Quantity:");
        label2.setBounds(10, 60, 200, 25);
        quantity = new JTextField();
        quantity.setBounds(200, 60, 50, 25);  //not showing up
        add(label2);
        add(quantity);

        JLabel label3 = new JLabel("Minimum Amount of Grocery:");
        label3.setBounds(10, 100, 200, 25);
        minAmount = new JTextField();
        quantity.setBounds(200, 100, 50, 25);
        add(label3);
        add(minAmount);
    }

    @Override
    protected void save() {
        Grocery g = new Grocery(name.getText(), Integer.parseInt(quantity.getText()),
                Integer.parseInt(minAmount.getText()));
        inventory.addGrocery(g);
        super.save();
    }

}

// box to add new name
// box to add new quantity
// box to add new min amount

// when user inputs all these grocery fields and hits "save",
// grocery item is added to inventory and changes reflect on home page