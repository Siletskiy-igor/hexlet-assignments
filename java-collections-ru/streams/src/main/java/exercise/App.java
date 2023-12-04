package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static List<String> freeEmails = new ArrayList<>(List.of("@gmail.com", "@yandex.ru", "@hotmail.com"));
    public static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .filter(x -> freeEmails.contains(x.substring(x.indexOf('@'))))
                .count();
    }
}
// END
