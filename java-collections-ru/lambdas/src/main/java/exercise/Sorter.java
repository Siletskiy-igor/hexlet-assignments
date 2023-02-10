package exercise;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(x -> x.containsValue("male"))
                .sorted((a, b) -> a.get("birthday").compareTo(b.get("birthday")))
                .map(y -> y.get("name"))
                .collect(Collectors.toList());

    }
}