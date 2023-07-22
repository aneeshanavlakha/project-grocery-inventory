package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroceryTest {
    private Grocery banana;

    @BeforeEach
    void runBefore(){
        banana = new Grocery("Banana", 12);
    }

    @Test
    public void testConstruct() {
      assertEquals("Banana", banana.name);
      assertEquals(12, banana.quantity);
      assertEquals(0, banana.lowerLimit);
    }

    @Test
    public void testChangeName() {
        banana.changeName("monkey");
        assertEquals("monkey", banana.getGroceryName());
    }

    @Test
    public void testAlert() {
        banana.setLowerLimit(3);
        banana.setQuantity(3);
        assertEquals(3, banana.getQuantity());
        assertEquals(3, banana.getLowerLimit());
        assertEquals("Running low!", banana.alert());

        banana.updateQuantity(-2);
        assertEquals(1, banana.getQuantity());
        assertEquals("You are 2 items below limit", banana.alert());

        banana.setQuantity(0);
        assertEquals("Out of stock - buy more!", banana.alert());
    }
}