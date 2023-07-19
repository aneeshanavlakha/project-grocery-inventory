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
        assertEquals("") //how do i test smth with output string?
    }
}