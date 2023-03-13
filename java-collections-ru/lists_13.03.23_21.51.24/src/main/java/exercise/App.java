package exercise;

import java.util.List;
import java.util.ArrayList;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        var lettersUniq = letters.toLowerCase();
        char[] lettersArray = lettersUniq.toCharArray();
        List<Character> lettersList = new ArrayList<>();
        for (var letter : lettersArray) {
            lettersList.add(letter);
        }
        var wordLettersUniq = word.toLowerCase();
        char[] wordLettersArray = wordLettersUniq.toCharArray();
        List<Character> wordLettersList = new ArrayList<>();
        for (var wordLetter : wordLettersArray) {
            wordLettersList.add(wordLetter);
        }

        for (var i = 0; i < wordLettersList.size(); i++) {
            if (lettersList.contains(wordLettersList.get(i))) {
                lettersList.remove(wordLettersList.get(i));
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
