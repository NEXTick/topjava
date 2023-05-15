<%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 25.04.2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meals</title>
    <style>
        .normal {
            color: green;
        }
        .excess {
            color: red;
        }
    </style>
</head>
<body>
        <table border="1">
            <thead>
            <tr>
                <th>Description</th>
                <th>DateTime</th>
                <th>Calories</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${meals}" var="meal" >

                <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
                <tr class="${meal.excess ? "excess" : "normal"}">
                    <td><c:out value="${meal.description}" /></td>
                    <td>
                        <fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}" /></td>
                    <td><c:out value="${meal.calories}" /> </td>
                    <td><a href="meals?action=update&id=<c:out value="${meal.id}"/>">Update</a></td>
                    <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="meals?action=create">Add meal</a> </p>
</body>
</html>
