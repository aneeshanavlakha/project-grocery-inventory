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
    public void testAlert() {
        banana.setLowerLimit(3);
        banana.setQuantity(3);
        assertEquals("Running low!", banana.alert());

        banana.setQuantity(1);
        assertEquals("You are 2 items below limit", banana.alert());

        banana.setQuantity(0);
        assertEquals("Out of stock - buy more!", banana.alert());

    }
}