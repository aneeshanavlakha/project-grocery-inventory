package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Modeled on JsonSerializationDemo
public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Inventory inv = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    //UPDATE testReaderEmptyInventory.json
    @Test
    void testReaderEmptyInventory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyInventory.json");
        try {
            Inventory inv = reader.read();
            assertEquals(0, inv.getNumGroceries());
            assertEquals(0, inv.getValue());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralInventory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralInventory.json");
        try {
            Inventory inv = reader.read();
            List<Grocery> groceries = inv.getGroceries();
            int value = inv.getValue();
            assertEquals(3, groceries.size());
            assertEquals(0, value);
            checkGrocery("banana", 12, 4, groceries.get(0));
            checkGrocery("apple", 6, 1, groceries.get(1));
            checkGrocery("milk", 5, 2, groceries.get(2));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
