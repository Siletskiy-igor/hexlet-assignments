package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage obj) {
        Map<String, String> storage = obj.toMap();
        for (var pare : storage.entrySet()) {
            String key = pare.getKey();
            String value = pare.getValue();
            obj.unset(key);
            obj.set(value, key);
        }
    }
}
// END
