<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>支付</title>
    <link rel="icon" href="img/logo.ico">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/pay.css">
</head>
<body>
    <div class="name">
        藏书阁
    </div>
    <div class="container">
        <ul>
            <li>微信支付</li>
            <li>支付宝支付</li>
        </ul>
        <div class="price"></div>
    </div>
    <div class="index"><a href="${pageContext.request.contextPath}/indexServlet?classly=1">返回主页</a></div>
</body>
</html>