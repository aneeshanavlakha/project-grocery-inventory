package persistence;

import model.Grocery;
import model.Inventory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Inventory inv = new Inventory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyInventory() {
        try {
            Inventory inv = new Inventory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInventory.json");
            writer.open();
            writer.write(inv);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInventory.json");
            inv = reader.read();
            assertEquals(0, inv.getGroceries().size());
            assertEquals(0, inv.getValue());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralInventory() {
        try {
            Inventory inv = new Inventory();
            inv.setValue(300);
            inv.addGrocery(new Grocery("peas", 15, 8));
            inv.addGrocery(new Grocery("spinach", 2, 1));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralInventory.json");
            writer.open();
            writer.write(inv);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralInventory.json");
            inv = reader.read();
            assertEquals(300, inv.getValue());
            List<Grocery> groceries = inv.getGroceries();
            checkGrocery("peas", 15, 8, groceries.get(0));
            checkGrocery("spinach", 2, 1, groceries.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}

