<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete</title>
    </head>
    <body>
        <p> серьезно хочешь удалить ${delete.get("firstName")} ?</p>
        <form action = '/users/delete?id=${delete.get("id")}' method = 'post'>
            <button type="submit" class="btn btn-danger">Удалить</button>
        </form>
    </body>
</html>
<!-- END -->
