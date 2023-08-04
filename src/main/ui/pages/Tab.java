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

    private JsonWriter jsonWriter;
    private JButton saveButton;
//    private JButton quitButton;

    protected Inventory inventory;

    public Tab(Inventory inventory) {
        setLayout(new BorderLayout());
        saveButton();
//        quitButton();

        this.inventory = inventory;
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    //??
    protected void saveButton() {
        saveButton = new JButton("Save");
//        saveButton.setBounds(300, 350, 25, 25);
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

//    //quit button (home tab overrides to null?)
//    private void quitButton() {
//        quitButton = new JButton("Quit");
//        quitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                quit();
//            }
//        });
//        add(quitButton, BorderLayout.SOUTH);  // causing a second panel on bottom half of screen
//    }
//
//    // EFFECTS: return to home tab
//    private void quit() {
//        cardLayout.show(mainPanel,);
}


