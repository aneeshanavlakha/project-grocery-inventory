package ui;

import model.Event;
import model.EventLog;
import model.Inventory;
import persistence.JsonReader;

import ui.pages.AddGroceryTab;
import ui.pages.ChangeValueTab;
import ui.pages.HomeTab;
import ui.pages.RemoveGroceryTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// A Grocery Inventory UI that allows users to keep track of groceries and the amount of money they spend on them
// Based on LongFormProblemStarters>SmartHome>UI>SmartHomeUI
// https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters/blob/
//                                                           ad73576d8c962430983dc95cca9a0344760b3679/SmartHome
public class GroceryInventoryUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int ADD_GROCERY_TAB_INDEX = 1;
    public static final int REMOVE_GROCERY_TAB_INDEX = 2;
    public static final int CHANGE_VALUE_TAB_INDEX = 3;
    private static final String JSON_STORE = "./data/inventory.json";
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private JTabbedPane sidebar;
    private Inventory inventory;
    private JsonReader reader;

    public static void main(String[] args) {
        new GroceryInventoryUI();
    }

    // MODIFIES: this
    // EFFECTS: creates GroceryInventoryUI, loads inventory, displays sidebar and tabs
    private GroceryInventoryUI() {
        super("My Inventory");

        setSize(WIDTH, HEIGHT);
        setBackground(Color.GRAY);

        inventory = new Inventory();
        loadInventory();

        EventLog.getInstance().clear();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.RIGHT);

        loadTabs();
        add(sidebar);

        windowActions();

        setVisible(true);
    }

    private void windowActions() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {
                for (Event e : EventLog.getInstance()) {
                    System.out.println(e);
                }
            }
        });
    }

    //EFFECTS: returns Inventory object controlled by this UI
    public Inventory getInventory() {
        return inventory;
    }

    // MODIFIES: this
    // EFFECTS: loads groceries and value from file
    public void loadInventory() {
        reader = new JsonReader(JSON_STORE);
        try {
            inventory = reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, add grocery tab, remove grocery tab and change value tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(inventory, this);
        JPanel addGroceryTab = new AddGroceryTab(inventory);
        JPanel removeGroceryTab = new RemoveGroceryTab(inventory);
        JPanel changeValueTab = new ChangeValueTab(inventory);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(addGroceryTab, ADD_GROCERY_TAB_INDEX);
        sidebar.setTitleAt(ADD_GROCERY_TAB_INDEX, "Add Grocery");
        sidebar.add(removeGroceryTab, REMOVE_GROCERY_TAB_INDEX);
        sidebar.setTitleAt(REMOVE_GROCERY_TAB_INDEX, "Remove Grocery");
        sidebar.add(changeValueTab, CHANGE_VALUE_TAB_INDEX);
        sidebar.setTitleAt(CHANGE_VALUE_TAB_INDEX, "Change Value");
    }

    public JTabbedPane getPane() {
        return sidebar;
    }

}

