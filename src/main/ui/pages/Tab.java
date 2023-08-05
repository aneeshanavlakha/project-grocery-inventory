package ui.pages;

import model.Inventory;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public abstract class Tab extends JPanel {
    private static final String JSON_STORE = "./data/inventory.json";
    protected JPanel centerPanel;
    private JsonWriter jsonWriter;
    protected JButton saveButton;

    protected Inventory inventory;

    public Tab(Inventory inventory) {
        setLayout(new BorderLayout());
        saveButton();
        this.inventory = inventory;
        jsonWriter = new JsonWriter(JSON_STORE);

        centerPanel = new JPanel(new GridLayout(3,2));
        add(centerPanel, BorderLayout.CENTER);
    }

    //??
    protected void saveButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        add(saveButton, BorderLayout.SOUTH);  // causing a second panel on bottom half of screen
    }

    //??
    protected void save() {
        System.out.println("Saved changes."); //remove
        try {
            jsonWriter.open();
            jsonWriter.write(inventory);
            jsonWriter.close();
            System.out.println("Saved inventory to " + JSON_STORE);  //remove
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);  //remove
        }
    }
}



