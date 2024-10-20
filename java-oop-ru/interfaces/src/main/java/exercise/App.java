package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        return homes.stream()
                .sorted((x, y) -> Double.compare(x.getArea(), y.getArea()))
                .limit(count)
                .map(Object::toString)
                .toList();
    }
}
// END
