<%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 25.04.2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Meals</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>Date</td>
        <td>Description</td>
        <td>Calories</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <f:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
        <tr>
            <td><f:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/></td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="update">Update</a></td>
            <td><a>Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
