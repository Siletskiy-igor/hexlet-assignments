package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
                .sorted((x, y) -> Double.compare(x.getArea(), y.getArea()))
                .map(Home::toString)
                .limit(count)
                .toList();

    }
}
// END
