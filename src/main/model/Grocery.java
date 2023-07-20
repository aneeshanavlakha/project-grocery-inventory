package model;

// A grocery is an item that has a name, quantity and assigned category
public class Grocery {
    String name;
    int quantity;
    int lowerLimit;

    public Grocery(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.lowerLimit = 0;
    }

    public void changeName(String name) {
        this.name = name;
    }

    //EFFECTS: if quantity is same as lower limit, issues a "running low" alert
    //         if quantity is lower than limit but at least 1, alerts how many items below limit
    //         if quantity is 0, issues an "out of stock" alert
    public String alert() {
        if (this.quantity == this.lowerLimit) {
            return "Running low!";
        } else if (this.quantity < this.lowerLimit && this.quantity > 0) {
            return "You are " + (this.lowerLimit - this.quantity) + " items below limit";
        } else if (this.quantity == 0) {
            return "Out of stock - buy more!";
        } else {
            return null;    //do i need this?
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //EFFECTS: updates quantity in a positive or negative way
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setLowerLimit(int limit) {
        this.lowerLimit = limit;
    }

    public String getGroceryName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }

}
