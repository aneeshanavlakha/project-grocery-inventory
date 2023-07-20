package model;

// a grocery category with a name, and list of groceries
// including their name and their quantity

//does this need to be an abstract superclass with
// each new category as a subclass?

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class Inventory {

    private List<Grocery> groceries; //FIX!
    private int value;

    public Inventory() {
        this.groceries = new ArrayList<Grocery>();
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

    public List<Grocery> getGroceries() {
        return this.groceries;
    }

    public void setValue(int amount) {
        this.value = amount;
    }

    public int getValue() {
        return this.value;
    }

}
