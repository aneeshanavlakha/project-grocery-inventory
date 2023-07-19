package model;

// a grocery category with a name, and list of groceries
// including their name and their quantity

//does this need to be an abstract superclass with
// each new category as a subclass?

import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class Inventory {

    private List<Grocery> groceries;
    private int value;

    public Inventory() {
        this.groceries = null;
        this.value = 0;
    }

    //MODIFIES: this, grocery
    //EFFECTS: adds a grocery to inventory
    public void addGrocery(String name, int quantity) {
        Grocery g = new Grocery(name, quantity);
        groceries.add(g);
    }

    //MODIFIES: this, category
    //EFFECTS: removes a grocery from inventory
    public void removeGrocery(Grocery grocery) {
        groceries.remove(grocery);
    }

    //MODIFIES: this
    //EFFECTS: Adds the amount spend to existing value
    public void setValue(int amount) {
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

}