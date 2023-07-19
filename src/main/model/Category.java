package model;

// a grocery category with a name, and list of groceries
// including their name and their quantity

//does this need to be an abstract superclass with
// each new category as a subclass?

import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class Category {

    private String categoryName;
    private List<Grocery> groceries;

    public Category() {
        this.categoryName = null;
        this.groceries = null;
    }

    //REQUIRES: input categoryName is an existing category  //how do i test this?
    //MODIFIES: this, grocery
    //EFFECTS: adds the given grocery to the grocery list in given category
    //         return true
    public boolean addGrocery(Grocery grocery, String categoryName) {
        groceries.add(grocery);
        return true;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }
    //MODIFIES: this, category
    //EFFECTS: removes a grocery from a category
    public void removeGrocery(Grocery grocery, Category category) {
        groceries.remove(grocery);
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<Grocery> getGroceries() {
        return this.groceries;
    }


}
