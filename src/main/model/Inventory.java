package model;

// a grocery category with a name, and list of groceries
// including their name and their quantity

//does this need to be an abstract superclass with
// each new category as a subclass?

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class Inventory {

    private List<Grocery> groceries;
    private int value;

    public Inventory() {
        this.groceries = new ArrayList<Grocery>();
        this.value = 0;
    }

    //MODIFIES: this, grocery
    //EFFECTS: adds a grocery to inventory
    //         if a grocery with the same name exists, returns false
    public boolean addGrocery(Grocery g) {
        int p =

        for (int i = 0; i <= getGroceries().size(); i++) {
            if (this.name = g.name) {
                return false;
            }  else {
                getGroceries().indexOf(this.groceries)
            }
        }

//        int highestIndex = 0;
//
//        for (int i = 1; i < this.getNumFoods(); i++) {
//            if (findFoodImpact(i) > findFoodImpact(highestIndex)) {
//                highestIndex = i;

        groceries.add(g);
        return true;
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
