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

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyInventory.json");
        try {
            Inventory inv = reader.read();
            assertEquals(0, inv.getNumGroceries());
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
            assertEquals(2, groceries.size());
            assertEquals(30, value);
            checkGrocery("banana", 12, 4, groceries.get(0));
            checkGrocery("milk", 2, 1, groceries.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
