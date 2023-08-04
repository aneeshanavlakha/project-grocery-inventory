package persistence;

import model.Inventory;

public class PersistedInventory extends Inventory {
    private static final String JSON_STORE = "./data/inventory.json";

    private Inventory inventory;
    private JsonReader reader;
    private JsonWriter writer;

    public PersistedInventory() {

    }




}
