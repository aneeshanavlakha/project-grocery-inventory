package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryTest {
    private Inventory inventory;
    private Grocery banana;
    private Grocery milk;
    private Grocery kale;

    @BeforeEach
    void runBefore() {
        inventory = new Inventory();
        banana = new Grocery("Banana", 12);
        milk = new Grocery("Milk", 3);
        kale = new Grocery("Kale", 5);
    }

    @Test
    public void testAddGroceryOne() {
        // add one grocery
        inventory.addGrocery(banana);
        assertEquals(banana, inventory.getGroceries().get(0));
    }

    @Test
    public void testAddGroceryMulti() {
        // add multiple groceries
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);

        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(milk, inventory.getGroceries().get(1));
    }

    @Test
    public void testRemoveGroceryMultiSame() {
        // add multiple of same
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);
        inventory.addGrocery(kale);
        inventory.addGrocery(banana);

        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(milk, inventory.getGroceries().get(1));
        assertEquals(kale, inventory.getGroceries().get(2));
        assertEquals(banana, inventory.getGroceries().get(3));
    }

    @Test
    public void testRemoveGrocery() {
        // remove one
        inventory.addGrocery(banana);
        inventory.addGrocery(milk);

        assertEquals(banana, inventory.getGroceries().get(0));
        assertEquals(milk, inventory.getGroceries().get(1));

        inventory.removeGrocery(milk);

        assertEquals(1, inventory.getGroceries().size());
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

        assertEquals(2, inventory.getGroceries().size());
    }

    @Test
    public void testRemoveGrocerySame() {
        // remove multiple instances of the same grocery
        inventory.addGrocery(banana);
        inventory.addGrocery(kale);
        inventory.addGrocery(banana);

        inventory.removeGrocery(banana);
        assertEquals(1, inventory.getGroceries().size());
    }
}