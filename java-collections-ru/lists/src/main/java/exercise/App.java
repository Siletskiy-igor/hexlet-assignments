package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        String lowerCaseWord = word.toLowerCase();
        ArrayList<String> lettersList = new ArrayList<>(Arrays.asList(letters.split("")));
        ArrayList<String> wordLettersList = new ArrayList<>(Arrays.asList(lowerCaseWord.split("")));

        for (var wordLetter : wordLettersList) {
            if (lettersList.contains(wordLetter)) {
                lettersList.remove(wordLetter);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
