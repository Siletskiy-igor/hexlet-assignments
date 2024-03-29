package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        return people.stream()
                .filter(x -> x.get("gender").equals("male"))
                .sorted((u1, u2) -> u1.get("birthday").compareTo(u2.get("birthday")))
                .map(u -> u.get("name"))
                .collect(Collectors.toList());
    }
}
// END
