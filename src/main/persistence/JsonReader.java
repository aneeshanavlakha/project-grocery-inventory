package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Modeled on JsonReader class in JsonSerializationDemo:
//                                https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
// Represents a reader that reads inventory from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads inventory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Inventory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseInventory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses inventory from JSON object and returns it
    private Inventory parseInventory(JSONObject jsonObject) {
        Inventory inv = new Inventory();
        addGroceries(inv, jsonObject);
        addValue(inv, jsonObject);
        return inv;
    }

    // MODIFIES: inv
    // EFFECTS: parses groceries from JSON object and adds them to inventory
    private void addGroceries(Inventory inv, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("groceries");
        for (Object json : jsonArray) {
            JSONObject nextGrocery = (JSONObject) json;
            addGrocery(inv, nextGrocery);
        }
    }

    // MODIFIES: inv
    // EFFECTS: parses grocery from JSON object and adds it to inventory
    private void addGrocery(Inventory inv, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int quantity = jsonObject.getInt("quantity");
        int minAmount = jsonObject.getInt("minAmount");
        Grocery grocery = new Grocery(name, quantity, minAmount);
        inv.addGrocery(grocery);
    }

    // MODIFIES: inv
    // EFFECTS: parses value from JSON object and adds it to inventory
    private void addValue(Inventory inv, JSONObject jsonObject) {
        int value = jsonObject.getInt("value");
        inv.setValue(value);
    }
}

