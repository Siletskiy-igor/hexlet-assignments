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
    <form method="post" action = "../users">
        <label>
            First Name
            <input type="text" name="firstName">
        </label>
        <label>
            Last Name
            <input type="text" name="lastName">
        </label>
        <label>
            Email
            <input type="email" name="email">
        </label>
        <label>
            Password
            <input type="password" name="password">
        </label>
        <input type="submit" value="Registration">
    </form>
</body>
</html>
