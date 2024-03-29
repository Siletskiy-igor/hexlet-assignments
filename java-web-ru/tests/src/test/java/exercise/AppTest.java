package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("users");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @Test
    void testCreateValidUser() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Max")
                .field("lastName", "Maximov")
                .field("email", "maxmaximov@gmail.com")
                .field("password", "888999")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(302);

        User user = new QUser()
                .lastName.equalTo("Maximov")
                .findOne();

        assertThat(user.getFirstName()).isEqualTo("Max");
        assertThat(user.getLastName()).isEqualTo("Maximov");
        assertThat(user.getEmail()).isEqualTo("maxmaximov@gmail.com");
        assertThat(user.getPassword()).isEqualTo("888999");

    }

    @Test
    void testCreateInvalidFirstNameUser() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "")
                .field("lastName", "Maximov")
                .field("email", "maxmaximov@gmail.com")
                .field("password", "888999")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(422);
        User user = new QUser()
                .lastName.equalTo("Maximov")
                .findOne();
        assertThat(user).isNull();

        String content = responsePost.getBody();

        assertThat(content).contains("Имя не должно быть пустым");
        assertThat(content).contains("Maximov").contains("maxmaximov@gmail.com");
    }

    @Test
    void testCreateInvalidLastNameUser() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Max")
                .field("lastName", "")
                .field("email", "maxmaximov@gmail.com")
                .field("password", "888999")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(422);
        User user = new QUser()
                .firstName.equalTo("Max")
                .findOne();
        assertThat(user).isNull();

        String content = responsePost.getBody();

        assertThat(content).contains("Фамилия не должна быть пустой");
        assertThat(content).contains("Max").contains("maxmaximov@gmail.com");

    }

    @Test
    void testCreateInvalidPasswordUser() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Max")
                .field("lastName", "Maximov")
                .field("email", "maxmaximov@gmail.com")
                .field("password", "555")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(422);
        User user = new QUser()
                .firstName.equalTo("Max")
                .findOne();
        assertThat(user).isNull();

        String content = responsePost.getBody();

        assertThat(content).contains("Пароль должен содержать не менее 4 символов");
        assertThat(content).contains("Max").contains("Maximov").contains("maxmaximov@gmail.com");
    }

    @Test
    void testCreateInvalidEmailUser() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Max")
                .field("lastName", "Maximov")
                .field("email", "maxmaximov@gmail.c")
                .field("password", "888999")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(422);
        User user = new QUser()
                .lastName.equalTo("Maximov")
                .findOne();
        assertThat(user).isNull();

        String content = responsePost.getBody();

        assertThat(content).contains("Должно быть валидным email");
        assertThat(content).contains("Max").contains("Maximov").contains("maxmaximov@gmail.c");
    }
    // END
}
