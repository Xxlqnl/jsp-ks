<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="icon" href="logo.ico">
    <style type="text/css">
        body{
            background:#feaa75 55%;
        }
        .container{
            width: 450px;
            height: 625px;
            border: 1px solid rgb(245, 240, 173);
            margin: 70px auto;
            border-radius: 2em;
            background:rgb(255, 255, 255);
            position: relative;
        }
        .container h2{
            text-align: center;
            margin: 50px;
            font-size: 29px;
            color: #000000;
            font-family: 楷体;
        }
        input[type="text"], input[type="password"]{
            border: 1px solid #dcdfe6;
            width: 350px;
            box-sizing: border-box;
            border-radius: 3px;
            height: 45px;
            text-indent: 1em;
            font-size: 14px;
            color: #0d0d0e;
            margin: 16px 48px;
            background:rgb(255, 255, 255);
        }
        input[type="text"]:hover, input[type="password"]:hover{
            border-color: #c0c4cc;
        }
        button{
            width: 350px;
            height: 45px;
            margin: 16px 48px;
            border-radius: 3px;
            background: rgb(255, 97, 13);
        }
        button:hover{
            background:rgb(255, 109, 32);
        }
        .container .login2{
            width: 100px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            position: absolute;
            right: 16px;
            bottom: 0;
            font-size: 14px;
            color: #FF610D
        }
        .container .adlogin{
            width: 100px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            position: absolute;
            left: 48px;
            bottom: 0;
            font-size: 14px;
            color: #00000073
        }
        .submit{
            background: transparent;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>账号登录</h2>
        <form action="loginServlet" method="post">
            <div class="item">
                <input type="text" name="username" placeholder="账号">
            </div>
            <div class="item">
                <input type="password" name="password" placeholder="密码（6-11位）">
            </div>
            <div class="button">
                <button><input class="submit" type="submit" value="登录" style="color: white"></button>
            </div>
            <p style="color: red;margin-left: 48px">${user}</p>
            <div class="login2">
                <a href="login2.jsp">注册</a>
            </div>
            <div class="adlogin">
                <a href="adlogin.jsp">后台管理员登录</a>
            </div>
        </form>
    </div>
</body>
</html>