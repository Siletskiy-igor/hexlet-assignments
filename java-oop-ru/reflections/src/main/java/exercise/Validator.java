package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        try {
            for(var field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    result.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
// END
