package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long x =  emails.stream()
                .filter(mails -> mails.endsWith("gmail.com"))
                .count();
        long y = emails.stream()
                .filter(mails -> mails.endsWith("yandex.ru"))
                .count();
        long z = emails.stream()
                .filter(mails -> mails.endsWith("hotmail.com"))
                .count();
        return x + y + z;
    }
}
// END
