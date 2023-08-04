package ui.pages;

import model.Grocery;
import model.Inventory;

public class RemoveGroceryTab extends Tab {

    public RemoveGroceryTab(Inventory inventory) {
        super(inventory);
        this.setLayout(super.getLayout());
        setUpPanel();
    }

    // EFFECTS: sets up dropdown with remove grocery option
    public void setUpPanel() {
        //stub
    }


    @Override
    protected void save() {
        // do something that matches the grocery we selected to a grocery in the inventory
        // then remove that from inventory
//        inventory.removeGrocery(g);
        super.save();
    }
}
//drop down menu with names of all current groceries
// when user selects a grocery and hits "save", grocery item is
// removed from inventory and changes reflect on home page

