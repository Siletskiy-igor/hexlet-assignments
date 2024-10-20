package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (var pairs : storage.toMap().entrySet()) {
            var currentKey = pairs.getKey();
            var currentValue = pairs.getValue();
            storage.unset(currentKey);
            storage.set(currentValue, currentKey);
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        System.out.println(storage.get("key", "default"));
        System.out.println(storage.get("value", "default"));
        System.out.println(storage.toMap());
    }
}
// END
