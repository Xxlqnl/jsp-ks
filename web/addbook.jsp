<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书上架</title>
    <link rel="stylesheet" type="text/css" href="css/addbook-css.css">
</head>
<body>
    <div class="header">
        <h1>图书后台管理</h1>
        <p>藏书阁</p>
    </div>
    
    <div class="left">
        <ul>
            <li><a  href="adindexServlet">图书管理</a></li>
            <li class="main"><a  class="main">图书上架</a></li>
            <li><a href="userServlet">用户管理</a></li>
            <li><a href="userServlet">退出登录</a></li>
        </ul>
    </div>
    <div class="table">
        <h1 style="display:inline-block">图书信息</h1>
        <p style="display: inline-block;color: red">${upbook}</p>
        <table border="1" cellspacing="0">
            <form action="addBookServlet" method="post" enctype="multipart/form-data">
                <tr>
                    <td>书名</td>
                    <td class="value">
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>价格</td>
                    <td class="value">
                        <input type="text" name="price">
                    </td>
                </tr>
                <tr>
                    <td>分类</td>
                    <td class="value">
                        <select name="classly">
                            <option value="儿童读物">儿童读物</option>
                            <option value="青年读物">青年读物</option>
                            <option value="科普百科">科普百科</option>
                            <option value="卡通动漫">卡通动漫</option>
                            <option value="名著宝藏">名著宝藏</option>
                        </select>
                    </td>
                </tr>
                <tr style="height: 100px;">
                    <td>详情</td>
                    <td class="value">
                        <textarea style="height: 80px;width: 300px;" name="detail"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>图片<span style="font-size: 10px;">（255px*255px）(不选择样书无法上传修改)</span></td>
                    <td class="value">
                        <input type="file" name="img" >
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="center">
                        <input type="submit" value="提交" class="submit">
                    </td>
                </tr>
            </form>
        </table>
    </div>
</body>
</html>