package exercise;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Map<String, String> data1 = data.toMap();
        for(Map.Entry<String, String> entry: data1.entrySet()) {
            data.unset(entry.getKey());
            data.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
