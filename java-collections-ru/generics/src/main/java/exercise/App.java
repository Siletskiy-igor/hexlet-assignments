package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> booksList, Map<String, String> where) {
        List<Map<String, String>> foundBooks = new ArrayList<>();
        for (var book: booksList) {
            if (book.entrySet().containsAll(where.entrySet())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
//END
