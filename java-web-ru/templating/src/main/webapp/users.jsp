<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <table>
        <c:forEach var="users" items="${users}">
            <tr>
                <td><a href='/users/show?id=${users.get("id")}'>${users.get("firstName")}</a></td>
                <td><a href='/users/show?id=${users.get("id")}'>${users.get("lastName")}</a></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
<!-- END -->
