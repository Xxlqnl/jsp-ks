<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/login2.css">
    <link rel="icon" href="logo.ico">
</head>
<body>
<div class="container">
    <h2>修改</h2>
    <form action="modifyUserServlet?id=${user.getId()}" method="post">
        <div class="item">
            <input type="text" name="username" value="${user.getUsername()}">
        </div>
        <div class="item">
            <input type="text" name="password" value="${user.getPassword()}">
        </div>
        <p style="color: red;margin-left: 48px">${mdify}</p>
        <div class="button">
            <button><input type="submit" value="修改"></button>
        </div>
    </form>
</div>
</body>
</html>