@import exercise.dto.users.UsersPage
@param UsersPage page
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="get" >
    <input type="search" name = "firstName">
    <input type="submit" value="Поиск">
    <table>
            @for(var user : page.getUsers())
                <tr>
                    <td>${user.getFirstName() + " " + user.getLastName()}</td>
                </tr>
            @endfor
    </table>
</form>
</body>
</html>
