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

        centerPanel = new JPanel(new GridLayout(3, 1));
        add(centerPanel, BorderLayout.CENTER);

        setUpPanel();
    }

    // MODIFIES: centerpanel
    // EFFECTS: displays up-to-date inventory value and a field to enter new value
    private void setUpPanel() {
        centerPanel.removeAll();
        displayValue(inventory);
        displayValueEntryObjects();
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // MODIFIES: centerpanel
    // EFFECTS: displays value in inventory
    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        centerPanel.add(heading, BorderLayout.NORTH);
    }

    // MODIFIES: centerpanel
    // EFFECTS: adds label and text box that allows user to input new value
    private void displayValueEntryObjects() {
        JPanel subPanel = new JPanel(new GridLayout(1, 2));
        JLabel label = new JLabel("Set new value: ");
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        valueEntry = new JTextField();

        subPanel.add(label);
        subPanel.add(valueEntry);
        centerPanel.add(subPanel);
    }


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
    // EFFECTS: displays image on lower panel
    private void displayImage() {
        ImageIcon icon = new ImageIcon(IMG_PATH);
        JLabel imageLabel = new JLabel(icon);

        centerPanel.add(imageLabel);
    }
}



