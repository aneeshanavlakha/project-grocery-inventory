package model;

// A grocery category with a name, and list of groceries
// including their name and their quantity


import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Grocery> groceries;
    private int value;


    //EFFECTS: an inventory with an empty grocery list and value set to 0
    public Inventory() {
        this.groceries = new ArrayList<>();
        this.value = 0;
    }

    //MODIFIES: this, grocery
    //EFFECTS: adds a grocery to inventory
    public void addGrocery(Grocery g) {
        groceries.add(g);
    }

    //MODIFIES: this, category
    //EFFECTS: removes a grocery from inventory
    public void removeGrocery(Grocery grocery) {
        groceries.remove(grocery);
    }

    //MODIFIES: this
    //EFFECTS: Adds the amount spend to existing value
    public void updateValue(int amount) {
        this.value += amount;
    }

    //MODIFIES: this
    //EFFECTS: resets existing value to 0
    public void reset() {
        this.value = 0;
    }

    public List<Grocery> getGroceries() {
        return this.groceries;
    }

    public void setValue(int amount) {
        this.value = amount;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Inventory:\nValue: " + value + "\nGroceries: " + groceries;
    }
}
