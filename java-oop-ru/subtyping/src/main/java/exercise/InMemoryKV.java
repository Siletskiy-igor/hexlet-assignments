package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> storage = new HashMap<>();

    InMemoryKV(Map<String, String> dataInitial) {
        storage.putAll(dataInitial);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!storage.containsKey(key)) {
            return defaultValue;
        }
        return storage.get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

}
// END
