package ui.pages;

import model.Inventory;

public class RemoveGroceryTab extends Tab {
    public RemoveGroceryTab(Inventory inventory) {
        super(inventory);
    }
    //drop down menu with names of all current groceries
    // when user selects a grocery and hits "save", grocery item is
    // removed from inventory and changes reflect on home page
}
