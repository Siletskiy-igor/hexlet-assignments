package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] wordsArray = sentence.split(" ");
        Map <String, Integer> wordsAndCounters = new HashMap<String, Integer>();
        Map <String, Integer> emptyMap = new HashMap<String, Integer>();
        if(sentence.equals("")){
            return emptyMap;
        }
        for (String word: wordsArray) {
            if (!wordsAndCounters.containsKey(word)) {
                wordsAndCounters.put(word, 1);
            }  else {
                wordsAndCounters.put(word, wordsAndCounters.get(word) + 1);
            }
        }
        System.out.println(wordsAndCounters);
        return wordsAndCounters;
    }

    public static String toString (Map <String, Integer> wordCount ) {
        if (wordCount.isEmpty()) {
            return "{}";
        }
        var result = "{";
        for (Map.Entry<String, Integer> pair: wordCount.entrySet()){
            result = result + "\n" + "  " + pair.getKey() + ": " + pair.getValue();
        }
        result = result + "\n" + "}";
        System.out.println(result);
        return result;
    }
}
//END
