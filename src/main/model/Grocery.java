package model;

// A grocery is an item that has a name, quantity and assigned category
public class Grocery {
    String groceryName;
    int quantity;

    public Grocery(String name, int quantity) {
        this.groceryName = name;
        this.quantity = quantity;
    }

    // EFFECTS: set the grocery name
    public void setGroceryName(String name) {
        this.groceryName = name;
    }

    // EFFECTS: set the grocery quantity
    public void setGroceryName(int quantity) {
        this.quantity = quantity;
    }

    // EFFECTS: returns the grocery name
    public String getGroceryName() {
        return this.groceryName;
    }

    // EFFECTS: returns the grocery quantity
    public int getQuantity() {
        return this.quantity;
    }

}
