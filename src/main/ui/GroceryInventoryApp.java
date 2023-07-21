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
    //EFFECTS: initializes groceries and inventories
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
            doUpdateGroceryCheck();
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
            doSetValue(inventory);
        } else if (selection.equals("u")) {
            doUpdateValue(inventory);
        } else {
            inventory.reset();
        }
    }

    public void doAddGrocery() {
        System.out.println("Enter new grocery name:");
        String name = input.next();

        System.out.println("Enter " + name + " quantity:");
        int quantity = input.nextInt();

        Grocery g = new Grocery(name, quantity);
        inventory.addGrocery(g);

        System.out.println("Added to inventory: " + "Grocery name - " + name + "Grocery quantity - " + quantity);

        //add ability to loop back to add groceries menu i.e. "add another grocery" directly? and then quit when wanted?
    }

    //FIX!!
    //MODIFIES: this
    //EFFECTS: remove grocery from inventory
    //         checks input grocery name against each item in the inventory
    //         if the inventory contains the name, produces true and removes it from inventory
    //         and print statement saying it has been removed
    //         if not produces false and error message saying "this grocery does not exist"
    //         allows user to re-input a grocery name
    public void doRemoveGrocery() {
        System.out.println(inventory.getGroceries());

        while (true) {
            System.out.println("Type grocery to remove or press q to quit");
            String name = input.next();
            if (name.equals("q")) {
                return;
            }
            for (int i = 0; i < inventory.getGroceries().size(); i++) {
                if (inventory.getGroceries().get(i).getGroceryName().equals(name)) {
                    Grocery g = inventory.getGroceries().remove(i);
                    System.out.println(g.getGroceryName() + " has been removed!");
                    return;
                }
            }
            System.out.println("Doesn't exist! Try again."); //why is this showing up for other methods too?
        }

    }

    //FIX!!
    //MODIFIES: this, inventory
    //EFFECTS: updates a given grocery's quantity or lower limit
    //         checks current grocery name against each item in the inventory
    //         if the inventory contains the name, produces true and allows user to proceed
    //         if not produces false and error message saying "this grocery does not exist"
    //         allows user to re-input a grocery name
    public void doUpdateGroceryCheck() {
        System.out.println(inventory.getGroceries());

        while (true) {
            System.out.println("Type grocery to update or press q to quit");
            String name = input.next();
            if (name.equals("q")) {
                return;
            }
            for (int i = 0; i < inventory.getGroceries().size(); i++) {
                if (inventory.getGroceries().get(i).getGroceryName().equals(name)) {
                    doUpdateGrocery();
                }
            }
            System.out.println("Doesn't exist! Try again.");
        }

        //add method to set alert
    }

    private void doUpdateGrocery() {
        String selection = "";

        while (!(selection.equals("s") || selection.equals("u") || selection.equals("l"))) {
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
        System.out.println("Input quantity to add: ");
        int quantity = input.nextInt();
        g.updateQuantity(quantity);

        System.out.println(g.getGroceryName() + " now has quantity " + g.getQuantity());
    }

    //MODIFIES: this
    //EFFECTS: sets lower limit for grocery
    private void doSetLowerLimit(Grocery g) {
        System.out.println("Input lower limit: ");
        int limit = input.nextInt();
        g.setLowerLimit(limit);

        System.out.println(g.getGroceryName() + "now has limit" + g.getLowerLimit());
    }

    //MODIFIES: this
    //EFFECTS: sets new value for inventory
    private void doSetValue(Inventory i) {
        System.out.println("Input new value: ");
        int value = input.nextInt();
        i.setValue(value);
    }

    //MODIFIES: this
    //EFFECTS: updates value for inventory by given value
    private void doUpdateValue(Inventory i) {
        System.out.println("Input value to update by: \nPositive value to add. \n Negative value to subtract.");
        int value = input.nextInt();
        i.updateValue(value);
    }

}

