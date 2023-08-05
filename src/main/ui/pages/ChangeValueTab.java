package ui.pages;

import model.Inventory;

import javax.swing.*;
import java.awt.*;

public class ChangeValueTab extends Tab {
    JTextField valueEntry;

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
        centerPanel.add(heading, BorderLayout.NORTH);
    }

    // EFFECTS: test box that allows user to input new value
    public void setUpPanel() {
        JLabel label = new JLabel("Set new value: ");
        label.setBounds(10, 60, 200, 25);
        valueEntry = new JTextField();
        valueEntry.setBounds(200, 60, 50, 25);  //box not showing up
        //add ability to only enter ints
        centerPanel.add(label);
        centerPanel.add(valueEntry);
    }

    @Override
    protected void save() {
        inventory.setValue(Integer.parseInt(valueEntry.getText()));
        super.save();
    }

    // current value displayed on top of page
    // text box that allows user to input new value
    // when user enters new number and hits "save", new value is updated in inventory and changes reflect
    // on home page
}


