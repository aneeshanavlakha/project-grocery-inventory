package ui;

import model.Grocery;
import model.Inventory;

import java.util.Scanner;

// Grocery inventory application
// based on UI modelling of TellerApp
public class GroceryInventoryApp {
    private Inventory inventory;
    private Grocery grocery;
    private Scanner input;

    //EFFECTS: run the grocery inventory application
    public GroceryInventoryApp() {
        runGroceryInventoryApp();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runGroceryInventoryApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("d")) {
                keepGoing = false;
                System.out.println(inventory.toString());
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHappy Eating!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("i")) {
            doManageInventory();
        } else {
            System.out.println("Please make a valid selection.");
        }
    }

    //MODIFIES: this
    //EFFECTS: initilizes groceries and inventories
    private void init() {
        inventory = new Inventory();
        grocery = new Grocery(null, 0);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n");
        System.out.println("\ti -> manage inventory");
        System.out.println("\td -> done");
    }

    //MODIFIES: this
    //EFFECTS: user can view or edit inventory
    private void doManageInventory() {
        System.out.println(inventory.toString());

        System.out.println("\nWould you like to..");
        selectInventoryAction();
    }

    //MODIFIES: this
    //EFFECTS: prompts user to select view or edit inventory
    private void selectInventoryAction() {
        String selection = "";

        while (!(selection.equals("g") || selection.equals("v"))) {
            System.out.println("g for manage groceries");
            System.out.println("v for manage value");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("g")) {
            doManageGroceries();
        } else {
            doManageValue();
        }
    }

    //MODIFIES: this
    //EFFECTS: manages a single grocery
    private void doManageGroceries() {
        System.out.println("\nWould you like to..");
        selectGroceriesAction();
    }

    private void doManageValue() {
        System.out.println("Current amount spent: " + inventory.getValue());
        selectValueAction();
    }

    //MODIFIES: this
    //EFFECTS: prompts user to select add or update grocery
    private void selectGroceriesAction() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("r") || selection.equals("u"))) {
            System.out.println("a for add new grocery");
            System.out.println("r for remove existing grocery");
            System.out.println("u for update existing grocery");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doAddGrocery();
        } else if (selection.equals("r")) {
            doRemoveGrocery();
        } else {
            doUpdateGrocery();
        }
    }

    private void selectValueAction() {
        String selection = "";

        while (!(selection.equals("s") || selection.equals("u") || selection.equals("r"))) {
            System.out.println("s for set value");
            System.out.println("u for update value");
            System.out.println("r for reset value");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("s")) {
            doSetValue();
        } else if (selection.equals("u")) {
            doUpdateValue();
        } else {
            doResetValue();
        }
    }

    public void doAddGrocery() {
        System.out.println("Enter new grocery name:");
        String name = input.next();

        System.out.println("Enter " + name + " quantity:");
        int quantity = input.nextInt();

        Grocery g = new Grocery(name, quantity);
        inventory.addGrocery(g);

        System.out.println("Added to inventory: "
                + "\tGrocery name - " + name
                + "\tGrocery quantity - " + quantity);

    }

    //MODIFIES: this
    //EFFECTS: remove grocery from inventory
    public void doRemoveGrocery() {
        //stub
    }

    //MODIFIES: this, inventory
    //EFFECTS: updates a given grocery's quantity or lower limit
    public void doUpdateGrocery() {
        System.out.println(inventory.getGroceries());

//        System.out.println("Type grocery to update: ");
//        String name = input.next();
//        if (inventory.getGroceries().contains(name)) {
//            Grocery g = inventory.getGroceries().get();  //!!FIX

        String selection = "";

        while (!((selection.equals("s")) || selection.equals("u")) || (selection.equals("l"))) {
            System.out.println("s for set quantity");
            System.out.println("u for update quantity");
            System.out.println("l for set lower limit");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("s")) {
            doSetQuantity(grocery);
        } else if (selection.equals("u")) {
            doUpdateQuantity(grocery);
        } else {
            doSetLowerLimit(grocery);
        }
    }

    //MODIFIES: this
    //EFFECTS: sets new quantity for grocery to given amount
    private void doSetQuantity(Grocery g) {
        System.out.println("Input new quantity: ");
        int quantity = input.nextInt();
        g.setQuantity(quantity);

        System.out.println(g.getGroceryName() + " now has quantity " + g.getQuantity());
    }

    private void doUpdateQuantity(Grocery g) {
        //stub
    }

    //MODIFIES: this
    //EFFECTS: sets lower limit for grocery
    private void doSetLowerLimit(Grocery g) {
        System.out.println("Input limit: ");
        int limit = input.nextInt();
        g.setLowerLimit(limit);

        System.out.println(g.getGroceryName() + "now has limit" + g.getLowerLimit());
    }

    private void doSetValue() {
        //stub
    }

    private void doUpdateValue() {
        //stub
    }

    private void doResetValue() {
        //stub
    }

}

