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
      assertEquals(0, banana.minAmount);
    }

    @Test
    public void testChangeName() {
        banana.updateName("monkey");
        assertEquals("monkey", banana.getGroceryName());
    }

    @Test
    public void testAlert() {
        banana.setMinAmount(3);
        banana.setQuantity(3);
        assertEquals(3, banana.getQuantity());
        assertEquals(3, banana.getMinAmount());
        assertEquals("Oi! Running low!", banana.alert());

        banana.updateQuantity(-1);
        assertEquals(2, banana.getQuantity());
        assertEquals("Oi! You are 1 items below limit!", banana.alert());

        banana.setQuantity(0);
        assertEquals("Oi! Out of stock - buy more!", banana.alert());

        banana.updateQuantity(4);
        assertEquals("", banana.alert());
    }

    @Test
    public void testSetMinAmount() {
        banana.setMinAmount(5);
        assertEquals(5, banana.getMinAmount());

        banana.setMinAmount(0);
        assertEquals(0, banana.getMinAmount());

        banana.setMinAmount(-1);
        assertEquals(0, banana.getMinAmount());
    }

    @Test
    public void testToString() {
        assertEquals("Name : Banana, Quantity : 12, Lower Limit: 0", banana.toString());
    }
}