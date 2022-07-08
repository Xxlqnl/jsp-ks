<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="icon" href="logo.ico">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/details.css">
</head>
<body>
<div class="book">
    <img src="${book.getImg()}">
</div>
<div class="details">
    <p>藏书阁</p>
    &nbsp;&nbsp;${book.getDetail()}
</div>
<div class="price">
    价格:￥${book.getPrice()}
</div>
<div class="button">
    <a href="${pageContext.request.contextPath}/adindexServlet">返回</a>
</div>

<div class="shop">
    <a href="shopping.jsp"><img src="img/购物车.png"></a>
</div>
</body>
</html>