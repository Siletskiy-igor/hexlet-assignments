<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit user</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <a href="/users">Все пользователи</a>
            <!-- BEGIN -->
            <form action="/users/edit" method="post">
                            <div class="mb-3">
                                <label>Имя</label>
                                <input class="form-control" type="text" name="firstName" value='${user.getOrDefault("firstName", " ")}'>
                            </div>
                            <div class="mb-3">
                                <label>Фамилия</label>
                                <input class="form-control" type="text" name="lastName" value='${user.getOrDefault("lastName", " ")}'>
                            </div>
                            <div class="mb-3">
                                <label>email</label>
                                <input class="form-control" type="text" name="email" value='${user.getOrDefault("email", " ")}'>
                            </div>
                            <button class="btn btn-primary" type="submit">изменить</button>
                        </form>
            <!-- END -->
        </div>
    </body>
</html>
