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
            command = input.nextLine();

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
        grocery = new Grocery("Banana", 12);  //needs to be more vague?
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

}
