package model;

// A grocery category with a name, and list of groceries
// including their name and their quantity


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Writable {

    private List<Grocery> groceries;  //List of all groceries in the inventory
    private int value;                //Amount of money spent on groceries thus far


    //EFFECTS: an inventory with an empty grocery list and value set to 0
    public Inventory() {
        this.groceries = new ArrayList<>();
        this.value = 0;
    }

    //MODIFIES: this
    //EFFECTS: adds a grocery to inventory
    public void addGrocery(Grocery g) {
        groceries.add(g);
    }

    //MODIFIES: this
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

    public int getNumGroceries() {
        return this.groceries.size();
    }

    public void setValue(int amount) {
        this.value = amount;
    }

    public int getValue() {
        return this.value;
    }

    // Modeled on JsonSerializationDemo
    //EFFECTS: returns entire inventory as a string
    @Override
    public String toString() {
        return "Inventory:\nValue: " + value + "\nGroceries: " + groceries;
    }

    // Modeled on JsonSerializationDemo
    //EFFECTS: creates new JsonObject with given inventory parameters
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("value", value);
        json.put("groceries", groceriesToJson());
        return json;
    }

    // Modeled on JsonSerializationDemo
    // EFFECTS: returns groceries in this inventory as a JSON array
    private JSONArray groceriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Grocery t : groceries) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
