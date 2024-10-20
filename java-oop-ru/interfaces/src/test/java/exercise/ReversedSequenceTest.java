package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversedSequenceTest {
    static ReversedSequence x;

    @BeforeAll
    public static void beforeAll() {
        x = new ReversedSequence("String");
    }

    @Test
    void length() {
        int actual = x.length();
        int expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    void charAt() {
        char actual = x.charAt(2);
        char expected = 'r';
    }

    @Test
    void subSequence() {
        CharSequence actual = x.subSequence(1, 4);
        CharSequence expected = "tri";
        assertEquals(actual, expected);

    }

    @Test
    void testToString() {
        String actual = x.toString();
        String expected = "gnirtS";
    }
}