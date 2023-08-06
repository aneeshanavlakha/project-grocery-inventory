package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryTest {
    private Inventory inventory;
    private Grocery banana = new Grocery("Banana", 12, 0);
    private Grocery milk = new Grocery("Milk", 3, 2);
    private Grocery kale = new Grocery("Kale", 5, 1);

    @BeforeEach
    void runBefore() {
        inventory = new Inventory();
    }

    @Test
    public void testConstruct() {
        assertEquals(0, inventory.getValue());
        assertEquals(0, inventory.getGroceries().size());
    }

    @Test
    public void testAddGroceryOne() {
        // add one grocery
        inventory.addGrocery(banana);
        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(1, inventory.getNumGroceries());
    }

    @Test
    public void testAddGroceryMulti() {
        // add multiple groceries
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);

        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(milk, inventory.getGroceries().get(1));
        assertEquals(2, inventory.getNumGroceries());

    }

    @Test
    public void testRemoveGrocery() {
        // remove one
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);

        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(milk, inventory.getGroceries().get(1));
        assertEquals(2, inventory.getNumGroceries());

        inventory.removeGrocery(milk);
        assertEquals(1, inventory.getNumGroceries());

    }

    @Test
    public void testRemoveGroceryMulti() {
        // remove multiple
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);
        inventory.addGrocery(kale);
        inventory.addGrocery(banana);

        inventory.removeGrocery(milk);
        inventory.removeGrocery(kale);

        assertEquals(2, inventory.getNumGroceries());
    }

    @Test
    public void testUpdateValueOne() {
        inventory.updateValue(90);
        assertEquals(90, inventory.getValue());
    }

    @Test
    public void testUpdateValueMulti() {
        inventory.setValue(90);
        inventory.updateValue(10);
        assertEquals(100, inventory.getValue());

        inventory.setValue(80);
        assertEquals(80, inventory.getValue());

        inventory.updateValue(50);
        assertEquals(130, inventory.getValue());
    }

    @Test
    public void testSetValue() {
        inventory.setValue(-1);
        assertEquals(0, inventory.getValue());

        inventory.setValue(0);
        assertEquals(0, inventory.getValue());

        inventory.setValue(1);
        assertEquals(1, inventory.getValue());
    }

    @Test
    public void testReset() {
        inventory.setValue(100);
        inventory.reset();
        assertEquals(0, inventory.getValue());
    }

    @Test
    public void testToString() {
        assertEquals("Inventory:\n" + "Value: 0\n" + "Groceries: []", inventory.toString());

        inventory.addGrocery(milk);
        assertEquals("Inventory:\n" + "Value: 0\n" +
                "Groceries: [Name : Milk, Quantity : 3, Min Amount: 0]", inventory.toString());
    }
}
