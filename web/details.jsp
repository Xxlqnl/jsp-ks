<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>详情</title>
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
    <form action="addShoppingServlet?name=${book.getName()}" method="post">
        <div class="num">
            <span>数量:</span>
            <!--<input type="text" name="number" class="tb-text mui-amount-input" value="1" maxlength="5" title="请输入购买量">-->
            <input type="text" name="number" class="tb-text mui-amount-input"  maxlength="5" title="请输入购买量">
        </div>
        <div class="button">
            <form> <input type="submit" value="加入购物车"></form>
        </div>
    </form>
    <div class="shop">
        <a href="shopping.jsp"><img src="img/购物车.png"></a>
    </div>
</body>
</html>