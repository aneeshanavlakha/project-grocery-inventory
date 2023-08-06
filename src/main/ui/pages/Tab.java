package ui.pages;

import model.Inventory;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// An abstract class that contains the save button and save function present in most Tabs
public abstract class Tab extends JPanel {
    private static final String JSON_STORE = "./data/inventory.json";
    protected JPanel centerPanel;
    private JsonWriter jsonWriter;
    protected JButton saveButton;
    protected Inventory inventory;

    // REQUIRES: inventory from store
    protected Tab(Inventory inventory) {
        this.inventory = inventory;
        this.jsonWriter = new JsonWriter(JSON_STORE);

        setLayout(new BorderLayout());
        saveButton();

        centerPanel = new JPanel(new GridLayout(3,2));
        add(centerPanel, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: save button that triggers save action on press
    protected void saveButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        add(saveButton, BorderLayout.SOUTH);
    }

    // REQUIRES: save button be pressed
    // MODIFIES: JSON_STORE
    // EFFECTS: writes user input to json
    protected void save() {
        System.out.println("Saved changes.");
        try {
            jsonWriter.open();
            jsonWriter.write(inventory);
            jsonWriter.close();
            System.out.println("Saved inventory to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}



