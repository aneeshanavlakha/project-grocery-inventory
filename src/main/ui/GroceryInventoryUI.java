package ui;

import model.Grocery;
import model.Inventory;
import ui.pages.AddGroceryTab;
import ui.pages.ChangeValueTab;
import ui.pages.HomeTab;
import ui.pages.RemoveGroceryTab;

import javax.swing.*;
import java.io.FileNotFoundException;

public class GroceryInventoryUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int ADD_GROCERY_TAB_INDEX = 1;
    public static final int REMOVE_GROCERY_TAB_INDEX = 2;
    public static final int CHANGE_VALUE_TAB_INDEX = 3;


    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private JTabbedPane sidebar;
    private Grocery grocery;
    private Inventory inventory;

    public static void main(String[] args) {
        new GroceryInventoryUI();
    }

    //MODIFIES: this
    // EFFECTS: creates GroceryInventoryUI, loads inventory, displays sidebar and tabs and view all button
    // DO I NEED TO LOAD (NOT DISPLAY) THE FULL INVENTORY TAB TOO?!!!

    private GroceryInventoryUI() {
        super("My Inventory");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        inventory = new Inventory();
        loadInventory();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);
        // how do i load the view all button?

        setVisible(true);
    }

    //EFFECTS: returns Inventory object controlled by this UI
    public Inventory getInventory() {
        return inventory;
    }

    // MODIFIES: this
    // EFFECTS: loads groceries and value from file
    private void loadInventory() {
        // stub
        // waht exactly does this do? how is it diff from home tab?
        // how do i load inventory from file?
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, add grocery tab, remove grocery tab and change value tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab();  //what is controller in smarthomeui?
        JPanel addGroceryTab = new AddGroceryTab();
        JPanel removeGroceryTab = new RemoveGroceryTab();
        JPanel changeValueTab = new ChangeValueTab();
        // do I need to load inventory tab even though it is not displaed in the side bar?

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(addGroceryTab,ADD_GROCERY_TAB_INDEX);
        sidebar.setTitleAt(ADD_GROCERY_TAB_INDEX, "Add Groceries");
        sidebar.add(removeGroceryTab, REMOVE_GROCERY_TAB_INDEX);
        sidebar.setTitleAt(REMOVE_GROCERY_TAB_INDEX, "Remove Groceries");
        sidebar.add(changeValueTab, CHANGE_VALUE_TAB_INDEX);
        sidebar.setTitleAt(CHANGE_VALUE_TAB_INDEX, "Change Value");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }






}


// ADD IN IF NEEDED
//        try {
//            new GroceryInventoryApp();
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }
