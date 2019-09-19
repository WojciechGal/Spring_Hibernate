<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 17.09.19
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        Login: <form:input path="login"/>
        Password: <form:password path="password"/>
        Email: <form:input path="email"/>
        <input type="submit" value="Save">
    </form:form>

    <!-- wyżej wcześniej było do wykomentowanego posta z person controller z inną składnią-->

</body>
</html>
