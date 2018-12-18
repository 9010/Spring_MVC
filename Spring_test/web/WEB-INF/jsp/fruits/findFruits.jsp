
<%--
  Created by IntelliJ IDEA.
  User: 11066
  Date: 2018/12/18
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"/>
    <title>水果列表</title>
</head>
<body>
    <form action="queryFruitsByCondition.action" method="post">
        名称：<input type="text" name="name"/>&nbsp;&nbsp;
        产地：<input type="text" name="producing_area"/>
        <input type="submit" value="搜索"/>
    </form>
    <hr/>
    <h3>搜索结果</h3>
    <table width="300px;" border="1">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>产地</td>
        </tr>

    <c:forEach items="${fruitsList }" var="fruits">
        <tr>
            <td>${fruits.name }</td>
            <td>${fruits.price  }</td>
            <td>${fruits.producing_area  }</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
