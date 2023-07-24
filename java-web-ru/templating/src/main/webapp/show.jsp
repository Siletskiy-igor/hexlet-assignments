<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Show</title>

    </head>
    <body>
        <tr>
        <td><p>${user.get("id")}</p></td>
        <td><p>${user.get("firstName")} ${user.get("lastName")}</p></td>
        <td><p>${user.get("email")}</p></td>
        <td><a href = '/users/delete?id=${user.get("id")}'>удалить</a></td>
        </tr>
    </body>
</html>
<!-- END -->
