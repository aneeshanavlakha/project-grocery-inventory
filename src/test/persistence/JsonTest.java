package persistence;

import model.Grocery;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Modeled on JsonTest class in JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonTest {
    protected void checkGrocery(String name, int quantity, int minAmount, Grocery grocery) {
        assertEquals(name, grocery.getGroceryName());
        assertEquals(quantity, grocery.getQuantity());
        assertEquals(minAmount, grocery.getMinAmount());
    }
}
