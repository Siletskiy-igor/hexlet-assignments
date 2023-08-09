package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationException;
import io.javalin.validation.Validator;
import io.javalin.validation.ValidationError;
import io.javalin.validation.JavalinValidation;
import org.apache.commons.lang3.StringUtils;
import io.javalin.http.Context;

import exercise.domain.User;
import exercise.domain.query.QUser;
import org.apache.commons.validator.routines.EmailValidator;

public final class UserController {

    private static void removeFlashMessage(Context ctx) {
        ctx.sessionAttribute("flash", null);
    }

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
        removeFlashMessage(ctx);
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN

        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

            var firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                    .check(value -> !value.isEmpty(), "поле \"name\"не может быть пустым");

            var lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                    .check(value -> !value.isEmpty(), "поле \" last name\"не может быть пустым");

            var emailValidator = ctx.formParamAsClass("email", String.class)
                    .check(value -> EmailValidator.getInstance().isValid(value), "невалидный имеил");

            var passwordValidator = ctx.formParamAsClass("password", String.class)
                    .check(StringUtils::isNumeric, "пароль не может содержать ничего кроме чисел")
                    .check(it -> it.length() >= 4, "пароль не может быть короче 4 символов");

            Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                    firstNameValidator,
                    lastNameValidator,
                    emailValidator,
                    passwordValidator
            );

            if (!errors.isEmpty()) {
                ctx.status(422);
                ctx.attribute("errors", errors);
                User invalidUser = new User(firstName, lastName, email, password);
                ctx.attribute("user", invalidUser);
                ctx.render("users/new.html");
                return;
            }



            User user = new User(firstName, lastName, email, password);
            user.save();

            ctx.sessionAttribute("flash", "Пользователь успешно создан");
            ctx.redirect("/users");


        // END
    };
}
