package exercise;

import lombok.*;

// BEGIN
@Getter
@AllArgsConstructor
@Data
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
