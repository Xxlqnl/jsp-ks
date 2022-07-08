<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <link rel="icon" href="/img/logo.ico">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
    <div class="head clearfix">
        <p><a href="${pageContext.request.contextPath}/indexServlet?classly=1">藏书阁</a></p>
        <h4>书籍是人类进步的阶梯</h4>
        <div class="img"><img src="img/电话 (1).png" alt="">400-1234-567</div>
        
    </div>
    <div class="body">
        <p>我的购物车</p>
        <div class="content clearfix">
            <ul>
                <li>商品</li>
                <li>数量</li>
                <li>价格</li>
                <li>删除</li>
            </ul>

            <div class="room">
                <div class="goods">
                  <table>
                      <c:forEach items="${shopping}" var="shopping" varStatus="s">
                          <tr>
                              <td style="vertical-align: middle;"> <img src="${shopping.img}"></td>
                              <td class="center">${shopping.number}</td>
                              <td class="center">&yen;${shopping.price}</td>
                              <td class="center"><a href="deleteShoppingServlet?id=${shopping.id}">删除</a></td>
                          </tr>
                      </c:forEach>
                  </table>
                </div>
            </div>
            <form action="deleteServlet" method="get">
                <ul>
                    <li>总计:${sum}</li>
                </ul>
                <input type="submit" value="结算">
            </form>
        </div>
    </div>
    <div class="foot">
        <ul>
            <li><a href="${pageContext.request.contextPath}/indexServlet?classly=1">返回主页</a></li>
            <li>关于我们</li>
            <li>商家合作</li>
            <li>常见问题</li>
            <li>其他服务</li>
         </ul>    
    </div>
</body>
</html>