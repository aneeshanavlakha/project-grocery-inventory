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
        this.categoryName = null;
        this.groceries = null;
    }

    //MODIFIES: this, grocery
    //EFFECTS: adds the given grocery to the grocery list in given category
    //         return true
    public void addGrocery(String name, int quantity) {
        Grocery g = new Grocery(name, quantity);
        groceries.add(g);
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }
    //MODIFIES: this, category
    //EFFECTS: removes a grocery from a category
    public void removeGrocery(Grocery grocery, Inventory category) {
        groceries.remove(grocery);
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<Grocery> getGroceries() {
        return this.groceries;
    }


}
