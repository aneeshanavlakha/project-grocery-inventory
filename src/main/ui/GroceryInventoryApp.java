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
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHappy Eating!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("g")) {
            doManageGrocery();
        } else if (command.equals("i")) {
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
        System.out.println("\tg -> manage groceries");
        System.out.println("\ti -> manage inventory");
        System.out.println("\td -> done");
    }

    //MODIFIES: this
    //EFFECTS: manages a single grocery
    private void doManageGrocery() {
        System.out.println("\nWould you like to..");
        selectGroceryAction();
    }

    //MODIFIES: this
    //EFFECTS: user can view or edit inventory
    private void doManageInventory() {
        //add ability to display inventory first
        System.out.println("\nWould you like to..");
        selectInventoryAction();
    }

    //MODIFIES: this
    //EFFECTS: prompts user to select add or update grocery
    private void selectGroceryAction() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("u"))) {
            System.out.println("a for add new grocery");
            System.out.println("u for update existing grocery");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doAddGrocery();
        } else {
            doUpdateGrocery();
        }
    }

    //MODIFIES: this
    //EFFECTS: prompts user to select view or edit inventory
    private void selectInventoryAction() {
        String selection = "";

        while (!(selection.equals("v") || selection.equals("e"))) {
            System.out.println("v for view inventory");
            System.out.println("e for edit inventory");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("v")) {
            doViewInventory();
        } else {
            doEditInventory();
        }
    }

    //!!FIX!!
    public void doAddGrocery() {
        System.out.println("Enter grocery name:");
        String name = input.nextLine();

        System.out.println("Enter grocery quantity:");
        int quantity = input.nextInt();

        Grocery g = new Grocery(name, quantity);

        System.out.println("Added to inventory: "
                + "\tGrocery name - " + name
                + "\tGrocery quantity - " + quantity);

    }

    //!!FIX
    //MODIFIES: this, inventory
    //EFFECTS: updates a given grocery's quantity or lower limit
    public boolean doUpdateGrocery() {
//        inventory.getGroceries();
//        System.out.println("Type grocery to update: ");
//        String name = input.nextLine();
//        if (inventory.groceries.contains(name)) {
//            Grocery g = inventory.groceries.get();  //!!FIX

        Grocery g = new Grocery(null, 0); //remove
        String selection = "";

        while (!((selection.equals("s")) || (selection.equals("l")))) {
            System.out.println("s for set quantity");
            System.out.println("l for set lower limit");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("s")) {
            doSetQuantity(g);
        } else if (selection.equals("l")) {
            doSetLimit(g);
        } else {
            System.out.println("Please make a valid selection.");
        }
        return true;
//        } else {
//            return false;
//        }
    }

    //MODIFIES: this
    //EFFECTS: sets new quantity for grocery to given amount
    private void doSetQuantity(Grocery g) {
        System.out.println("Input new quantity: ");
        int quantity = input.nextInt();
        g.setQuantity(quantity);

        System.out.println(g.getGroceryName() + " now has quantity " + g.getQuantity());
    }


    //MODIFIES: this
    //EFFECTS: sets lower limit for grocery
    private void doSetLimit(Grocery g) {
        System.out.println("Input limit: ");
        int limit = input.nextInt();
        g.setLowerLimit(limit);

        System.out.println(g.getGroceryName() + "now has limit" + g.getLowerLimit());
    }

    //MODIFIES: this
    //EFFECTS: view inventory (groceries and value)
    private void doViewInventory() {
        //stub
    }

    //MODIFIES: this
    //EFFECTS: choose to edit groceries or value
    private void doEditInventory() {
        String selection = "";

        while (!(selection.equals("g") || selection.equals("v"))) {
            System.out.println("g for edit groceries");
            System.out.println("v for edit value");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("g")) {
            doEditGrocery();
        } else {
            doEditValue();
        }
    }

    //MODIFIES: this
    //EFFECTS: add or remove a grocery from inventory
    private void doEditGrocery() {
        String selection = "";

        while (!(selection.equals("a") || selection.equals("r"))) {
            System.out.println("a for add new grocery");
            System.out.println("r for remove existing grocery");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("a")) {
            doAddGrocery();
        } else {
            doRemoveGrocery();
        }
    }

    //MODIFIES: this
    //EFFECTS: remove grocery from inventory
    private void doRemoveGrocery() {
        //stub
    }

    //MODIFIES: this
    //EFFECTS: set value in inventory
    private void doEditValue() {
        //stub
    }

    //add method for alerts
}

