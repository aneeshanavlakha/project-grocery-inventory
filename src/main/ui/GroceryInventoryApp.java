package ui;

import model.Grocery;
import model.Inventory;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Grocery inventory application
// Modelled on TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//         and JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class GroceryInventoryApp {
    private static final String JSON_STORE = "./data/inventory.json";
    private Inventory inventory;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: constructs inventory and runs the grocery inventory application
    public GroceryInventoryApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        inventory = new Inventory();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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


    //MODIFIES: this
    //EFFECTS: initializes groceries and inventories
    private void init() {
        inventory = new Inventory();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n");
        System.out.println("\ti -> manage inventory");
        System.out.println("\ts -> save inventory to file");
        System.out.println("\tl -> load inventory from file");
        System.out.println("\td -> done");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("i")) {
            doManageInventory();
        } else if (command.equals("s")) {
            saveInventory();
        } else if (command.equals("l")) {
            loadInventory();
        }  else {
            System.out.println("Please make a valid selection.");
        }
    }

    //MODIFIES: this
    //EFFECTS: user can view or edit inventory
    private void doManageInventory() {
        System.out.println(inventory.toString());

        System.out.println("\nWould you like to..");
        selectInventoryAction();
    }


    //EFFECTS: saves the inventory to file
    private void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.write(inventory);
            jsonWriter.close();
            System.out.println("Saved inventory to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: loads inventory from file
    private void loadInventory() {
        try {
            inventory = jsonReader.read();
            System.out.println("Loaded inventory from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
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
    //EFFECTS: manages the grocery list in inventory
    private void doManageGroceries() {
        System.out.println("\nWould you like to..");
        selectGroceriesAction();
    }

    //MODIFIES: this
    //EFFECTS: manages the value of inventory
    private void doManageValue() {
        System.out.println("Current value spent: " + inventory.getValue());
        selectValueAction();
    }

    //EFFECTS: prompts user to select add, remove or update grocery
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

    //EFFECTS: prompts user to select set new value/update current value/reset value of inventory
    private void selectValueAction() {
        String selection = "";

        while (!(selection.equals("s") || selection.equals("u") || selection.equals("r"))) {
            System.out.println("s for set new value");
            System.out.println("u for update current value");
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
            System.out.println(inventory.toString());
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a new grocery item to the grocery list in the inventory
    public void doAddGrocery() {
        System.out.println("Enter new grocery name:");
        String name = input.next();
        name = name.toLowerCase();
        System.out.println("Enter " + name + " quantity:");
        int quantity = input.nextInt();
        System.out.println("Enter " + name + " minAmount:");
        int minAmount = input.nextInt();

        Grocery g = new Grocery(name, quantity, minAmount);
        g.setMinAmount(minAmount);
        inventory.addGrocery(g);

        System.out.println("Added to inventory: " + "\nGrocery name: " + name + "\nGrocery quantity: " + quantity
                + "\nGrocery minAmount: " + minAmount);

        //add ability to loop back to add groceries menu i.e. "add another grocery" directly? and then quit when wanted?
    }

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
            if (name.equals("q")) {   //add this ability in all menus?
                return;
            }
            for (int i = 0; i < inventory.getGroceries().size(); i++) {
                if (inventory.getGroceries().get(i).getGroceryName().equals(name)) {
                    Grocery g = inventory.getGroceries().remove(i);
                    System.out.println(g.getGroceryName() + " has been removed!");
                    return;
                }
            }
            System.out.println("Doesn't exist! Try again.");
        }

    }

    //MODIFIES: this, inventory
    //EFFECTS: checks current grocery name against each item in the inventory
    //         if the inventory contains the name, produces true and allows user to proceed
    //         if not produces false and error message and allows user to re-input a grocery name
    public void doUpdateGroceryCheck() {
        System.out.println(inventory.getGroceries());

        while (true) {
            System.out.println("Type grocery to update or press q to quit");
            String name = input.next();
            name = name.toLowerCase();
            if (name.equals("q")) {
                return;
            }
            for (int i = 0; i < inventory.getGroceries().size(); i++) {
                Grocery current = inventory.getGroceries().get(i);
                if (current.getGroceryName().equals(name)) {
                    doUpdateGrocery(current);
                } else {
                    System.out.println("Doesn't exist! Try again.");
                }
            }

        }
    }

    //EFFECTS: prompts user to select update a grocery name, set/update a grocery quantity,
    //         or set a new minimum amount for a grocery
    private void doUpdateGrocery(Grocery g) {
        String selection = "";

        while (!(selection.equals("n") || (selection.equals("s") || selection.equals("u") || selection.equals("m")))) {
            System.out.println("n for update current name");
            System.out.println("s for set new quantity");
            System.out.println("u for update current quantity");
            System.out.println("m for set minimum amount");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("n")) {
            doUpdateName(g);
        } else if (selection.equals("s")) {
            doSetQuantity(g);
        } else if (selection.equals("u")) {
            doUpdateQuantity(g);
        } else {
            doSetNewMinAmount(g);
        }
    }

    //MODIFIES: this
    //EFFECTS: updates grocery name to given name
    private void doUpdateName(Grocery g) {
        System.out.println("Enter new name for " + g.getGroceryName());
        String name = input.next();
        g.updateName(name);

        System.out.println("Updated name to " + g.getGroceryName());
    }

    //MODIFIES: this
    //EFFECTS: sets new quantity for grocery to given amount
    private void doSetQuantity(Grocery g) {
        System.out.println("Input new quantity: ");
        int quantity = input.nextInt();
        g.setQuantity(quantity);

        System.out.println(g.getGroceryName() + " now has quantity " + g.getQuantity());

        System.out.println(g.alert());

    }

    //MODIFIES:
    //EFFECTS: updates quantity of this grocery by the given amount
    private void doUpdateQuantity(Grocery g) {
        System.out.println("Input value to update by: \nPositive value to add. \nNegative value to subtract.");
        int quantity = input.nextInt();
        g.updateQuantity(quantity);

        System.out.println(g.getGroceryName() + " now has quantity " + g.getQuantity());

        System.out.println(g.alert());
    }

    //MODIFIES: this
    //EFFECTS: sets the minimum amount for a grocery
    private void doSetNewMinAmount(Grocery g) {
        System.out.println("Input minAmount: ");
        int minAmount = input.nextInt();
        g.setMinAmount(minAmount);

        System.out.println(g.getGroceryName() + " now has minAmount " + g.getMinAmount());
    }

    //MODIFIES: this
    //EFFECTS: sets new value for inventory
    private void doSetValue(Inventory i) {
        System.out.println("Input new value: ");
        int value = input.nextInt();
        i.setValue(value);

        System.out.println(inventory.toString());
    }

    //MODIFIES: this
    //EFFECTS: updates value for inventory by given value
    private void doUpdateValue(Inventory i) {
        System.out.println("Input value to update by: \nPositive value to add. \n Negative value to subtract.");
        int value = input.nextInt();
        i.updateValue(value);

        System.out.println(inventory.toString());
    }
}

