<%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 10.05.2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit meal</title>
</head>
<body>
<form method="POST" action='meals' name="frmAddMeal">
    Description : <input
        type="text" name="description"
        value="<c:out value="${meal.description}" />"/> <br/>
    Calories : <input
        type="text" name="calories"
        value="<c:out value="${meal.calories}" />"/> <br/>
    DateTime : <input
    type="text" name="dateTime"
    value="<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${meal.dateTime}" />" /> <br />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
