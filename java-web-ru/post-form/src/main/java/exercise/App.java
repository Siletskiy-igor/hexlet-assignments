package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Collections;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
           var firstName = ctx.formParam("firstName").substring(0, 1).toUpperCase().trim() + ctx.formParam("firstName").substring(1).toLowerCase().trim();
           var lastName = ctx.formParam("lastName").substring(0, 1).toUpperCase().trim() + ctx.formParam("lastName").substring(1).toLowerCase().trim();
           var email = ctx.formParam("email").toLowerCase().trim();
           var password = Security.encrypt(ctx.formParam("password"));

           User user = new User(firstName, lastName, email, password);
           UserRepository.save(user);
           ctx.redirect("/users");

        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
