package ui.pages;

import model.Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangeValueTab extends Tab {
    JTextField v;

    public ChangeValueTab(Inventory inventory) {
        super(inventory);
        displayValue(inventory);
        setUpPanel();
    }

    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);
    }

    // EFFECTS: test box that allows user to input new value
    public void setUpPanel() {
        JLabel label = new JLabel("Grocery Quantity:");
        label.setBounds(10, 60, 200, 25);
        v = new JTextField();
        v.setBounds(200, 60, 50, 25);  //box not showing up
        //add ability to only enter ints
        add(label);
        add(v);
    }

    @Override
    protected void save() {
        inventory.setValue(Integer.parseInt(v.getText()));
        super.save();
    }


    // current value displayed on top of page
    // text box that allows user to input new value
    // when user enters new number and hits "save", new value is updated in inventory and changes reflect
    // on home page
}
