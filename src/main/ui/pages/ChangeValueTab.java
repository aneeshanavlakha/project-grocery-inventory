package ui.pages;

import model.Inventory;
import javax.swing.*;
import java.awt.*;

// Change Value tab of UI
public class ChangeValueTab extends Tab {
    private JTextField valueEntry;
    private static String IMG_PATH = "data/projectimage.jpg";

    // REQUIRES: inventory from store
    public ChangeValueTab(Inventory inventory) {
        super(inventory);
        setUpPanel();
    }

    // MODIFIES: centerpanel
    // EFFECTS: refreshes this tab to display up-to-date inventory value and a field to enter new value
    private void setUpPanel() {
        centerPanel.removeAll();
        displayValue(inventory);
        displayValueEntryObjects();
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // REQUIRES: input is >= 0
    // MODIFIES: centerpanel
    // EFFECTS: label and text box that allows user to input new value
    private void displayValueEntryObjects() {
        JLabel label = new JLabel("Set new value: ");
        label.setBounds(10, 60, 200, 25);
        valueEntry = new JTextField();
        valueEntry.setBounds(200, 60, 50, 25);
        centerPanel.add(label);
        centerPanel.add(valueEntry);
    }

    // MODIFIES: inventory, centerpanel
    // EFFECTS: displays value in inventory
    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(heading, BorderLayout.NORTH);
    }

    // REQUIRES: same as super
    // MODIFIES: inventory, centerpanel
    // EFFECTS:  saves value input to store, refreshes page to display new value, calls on image
    @Override
    protected void save() {
        inventory.setValue(Integer.parseInt(valueEntry.getText()));
        super.save();
        setUpPanel();
        displayImage();
    }

    // MODIFIES: centerpanel
    // EFFECTS: displays image on panel
    private void displayImage() {
        ImageIcon icon = new ImageIcon(IMG_PATH);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(100, 200, 5, 5);
        centerPanel.add(imageLabel);
    }
}



