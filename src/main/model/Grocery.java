package model;

import org.json.JSONObject;
import persistence.Writable;

// A grocery is an item that has a name, quantity and assigned category
public class Grocery implements Writable {
    String name;
    int quantity;
    int minAmount;

    //EFFECTS: a grocery with given name and quantity, and minAmount = 0
    public Grocery(String name, int quantity, int minAmount) {
        this.name = name;
        this.quantity = quantity;
        this.minAmount = minAmount;
    }

    //REQUIRES: lower limit is >= 0
    //EFFECTS: if quantity is same as lower limit, issues a "running low" alert
    //         if quantity is lower than limit but at least 1, alerts how many items below limit
    //         if quantity is 0, issues an "out of stock" alert
    public String alert() {
        if (this.quantity == this.minAmount) {
            return "Oi! Running low!";
        } else if (this.quantity < this.minAmount && this.quantity > 0) {
            return "Oi! You are " + (this.minAmount - this.quantity) + " items below limit!";
        } else if (this.quantity == 0) {
            return "Oi! Out of stock - buy more!";
        } else {
            return "";
        }
    }

    //MODIFIES: this
    //EFFECTS: updates grocery name to given name
    public void updateName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECTS: updates quantity in a positive or negative way
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //EFFECTS: sets a value on the minimum number of pieces the user
    //         ideally wants for this grocery at all times.
    //         minAmount cannot be < 0
    public void setMinAmount(int minAmount) {
        if (minAmount >= 0) {
            this.minAmount = minAmount;
        } else {
            this.minAmount = 0;
        }
    }

    public String getGroceryName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getMinAmount() {
        return this.minAmount;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", Quantity : " + quantity + ", Min Amount: " + minAmount;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("quantity", quantity);
        json.put("minAmount", minAmount);
        return json;
    }

}
