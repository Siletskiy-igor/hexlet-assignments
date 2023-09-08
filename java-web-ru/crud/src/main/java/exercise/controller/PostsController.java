package exercise.controller;

import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) throws IndexOutOfBoundsException{
        Integer pageCount = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.getEntities().stream()
                .skip((pageCount - 1) * 5)
                .limit(5)
                .toList();
        var page = new PostsPage(posts, pageCount);

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var article = PostRepository.find(id);
        if(article == null) {
            throw new NotFoundResponse("Page not found");
        } else {
            var page = new PostPage(article);
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
        }
    }

    // END
}
