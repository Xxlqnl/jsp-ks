<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/index-css.css">
</head>
<body>
<div class="header">
    <h1>图书后台管理</h1>
    <p>藏书阁</p>
</div>


<div class="left">
    <ul>
        <li><a href="adindexServlet">图书管理</a></li>
        <li><a href="addbook.jsp">图书上架</a></li>
        <li class="main"><a  class="main">用户管理</a></li>
        <li><a href="adlogin.jsp">退出登录</a></li>
    </ul>
</div>


<div class="tab">
    <table border="1" cellspacing="0">
        <tr class="tab-header">
            <td class="id">编号</td>
            <td class="name">账号</td>
            <td class="classly">密码</td>
            <td class="operating">操作</td>
        </tr>
        <c:forEach items="${users}" var="users" varStatus="u">
            <tr>
                <td>${u.count}</td>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/returnUserServlet?id=${users.id}&username=${users.username}&password=${users.password}">
                        <span class="iconfont">&#xe619;</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/deleteUserServlet?id=${users.id}">
                        <span class="iconfont">&#xe852;</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>