package persistence;

import model.Grocery;

import static org.junit.jupiter.api.Assertions.assertEquals;

// modeled on JsonSerializationDemo
public class JsonTest {
    protected void checkGrocery(String name, int quantity, int minAmount, Grocery grocery) {
        assertEquals(name, grocery.getGroceryName());
        assertEquals(quantity, grocery.getQuantity());
        assertEquals(minAmount, grocery.getMinAmount());
    }
}
