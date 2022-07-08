<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>藏书阁</title>
    <link rel="icon" href="img/logo.ico">
    <link rel="stylesheet" href="css/reset.css">
    <style type="text/css">
        *{
            margin: 0;
            border: 0;
            padding: 0;
        }
        .clearfix::after{
            content:"";
            display: block;
            clear: both;
        }
        body{
            background-color: #e0ddd1;
        }
        .top{
            height: 30px;
            background:#feaa75;
            line-height: 30px;
        }
        .top h2{
            display: block;
            width: 300px;
            color:rgb(17, 9, 9);
            font-size: 20px;
            padding: 0 20px;
            float: left;
        }
        .top h5{
            display: block;
            width: 100px;
            color: rgb(37, 31, 31);
            float: right;
            font-family: 楷体;
        }
        .left{
            width: 200px;
            height: 600px;
            border: rgba(0,0,0,0);
            position: absolute;

        }
        .left h2{
            text-align: center;
            width: auto;
            height: 50px;
            line-height: 50px;
            border: rgba(0,0,0,0);
            margin: 10px auto;
            border-radius: 2px;
            background: sandybrown;
        }
        .left ul li{
            width: 190px;
            height: 50px;
            border: rgba(0,0,0,0);
            margin: 20px auto;
            text-align: center;
            line-height: 50px;
            background-color: rgb(255, 97, 13);
            border-radius: 10px;
            color: white;
        }
        .left ul li:hover{
            background-color: rgb(255, 109, 32);
        }
        .left ul li a{
            width: 190px;
            height: 50px;
            display:block;
        }
        .body{
            width: 1500px;
            min-width: 500px;
            height: 800px;
            border: rgba(0,0,0,0);
            margin-left: 318px;
            margin-right: auto;
            display: inline-block;
        }
        .right{
            width: 300px;
            height: 800px;
            border: rgba(0,0,0,0);
            float: right;
        }
        .body .movie-item .poster img {
            width: 160px;
            height: 220px;
        }
        .body .movie-item .name{
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            padding: 0 2px;
            text-align: center;
        }

        .body  .movie-item .score{
            color:#ffb400;
            text-align: center;
            line-height: 2.5;
            font-style: italic;

        }
        .body .movie-item{
            float: left;
            width: 160px;
            margin-top: 20px;
            margin-right: 100px;
            margin-left: 70px;
        }
        .body .movie-item:nth-child(6n){
            margin-right: 0;
        }

        .body .movie-item .poster img{
            width: 160px;
            height: 220px;
        }
    </style>
</head>
<body>
<div class="top clearfix">
    <h2>藏书阁欢迎你的到来！</h2>
    <h5></h5>
    <h5><a href="${pageContext.request.contextPath}/shoppingServlet">购物车</a></h5>
    <h5><a href="login.jsp">登录</a> <a href="login2.jsp">注册</a></h5>

</div>
<div class="left">
    <h2>图书分类</h2>
    <ul>
        <li><a>儿童读物</a></li>
        <li><a href="${pageContext.request.contextPath}/indexServlet?classly=青年读物">青年读物</a></li>
        <li><a href="${pageContext.request.contextPath}/indexServlet?classly=科普百科">科普百科</a></li>
        <li><a href="${pageContext.request.contextPath}/indexServlet?classly=卡通动漫">卡通动漫</a></li>
        <li><a href="${pageContext.request.contextPath}/indexServlet?classly=名著宝藏">名著宝藏</a></li>
    </ul>
</div>
<div class="body">
    <c:forEach items="${book}" var="book" varStatus="b">
        <div class="movie-item">
            <div class="poster">
                <a href="${pageContext.request.contextPath}/detailsServlet?name=${book.name}">
                    <img src="${book.img}">
                </a>
            </div>
            <div class="name">
                <a href="${pageContext.request.contextPath}/detailsServlet?name=${book.name}">
                        ${book.name}
                </a>
            </div>
            <div class="score">￥${book.price}</div>
        </div>
    </c:forEach>
</div>
</div>
</body>
</html>