<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 18.09.19
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Path</th>
        <th>Message</th>
    </tr>
    <c:forEach items="${errors}" var="error">
        <tr>
            <td>${error.path}</td>
            <td>${error.message}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
