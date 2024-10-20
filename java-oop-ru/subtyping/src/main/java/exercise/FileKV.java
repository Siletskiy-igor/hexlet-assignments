package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String path;
    Map<String, String> storage;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.storage = new HashMap<>(storage);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(path,Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!Utils.unserialize(Utils.readFile(path)).containsKey(key)) {
            return defaultValue;
        }
        return Utils.unserialize(Utils.readFile(path)).get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
