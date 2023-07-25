package persistence;

import org.json.JSONObject;

// modeled on JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}