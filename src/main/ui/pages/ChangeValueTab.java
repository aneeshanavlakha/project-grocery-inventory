package ui.pages;

import model.Inventory;

public class ChangeValueTab extends Tab {
    public ChangeValueTab(Inventory inventory) {
        super(inventory);
    }
    // current value displayed on top of page
    // text box that allows user to input new value
    // when user enters new number and hits "save", new value is updated in inventory and changes reflect
    // on home page
}
