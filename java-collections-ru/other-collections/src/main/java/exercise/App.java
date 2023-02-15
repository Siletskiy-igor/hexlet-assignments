package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        var set1 = data1.entrySet();
        var set2 = data2.entrySet();
        return Stream.concat(set1.stream(), set2.stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        x -> data1.containsValue(x.getValue()) ? "deleted" : "added",
                        (v1, v2) -> v1.equals(v2) ? "unchanged" : "changed", LinkedHashMap::new));
    }
}
//END
