package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> dictionary = new HashMap<>();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        if (sentence.isEmpty()) {
            return new HashMap<>();
        }

        for (var word : wordList) {
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, 1);
            } else {
                dictionary.put(word, dictionary.get(word) + 1);
            }
        }
        return dictionary;
    }

    public static String toString(Map<String, Integer> dictionary) {
        if (dictionary.isEmpty()) {
            return "{}";
        }
        
        String result = "{";
        for (var entry : dictionary.entrySet()) {
            result += "\n" + "  " + entry.getKey() + ": " + entry.getValue();
        }
        result += "\n" + "}";
        return result;
    }
}
//END
