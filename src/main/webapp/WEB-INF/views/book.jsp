<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 17.09.19
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <form:form method="post" modelAttribute="book">

        <form:hidden path="id" value="${book.id}"/>
        <div>
            <label>Title:
                <form:input path="title"/>
            </label>
            <!--tu walidacja z trzeciego dnia-->
            <form:errors path="title" element="div" cssStyle="color:red"/>
        </div>
        <div>
            <label>Rating:
                <form:select path="rating">
                    <c:forEach begin="1" end="10" var="number">
                        <form:option value="${number}"/>
                    </c:forEach>
                </form:select>
            </label>
            <form:errors path="rating" element="div" cssStyle="color:red"/>
        </div>
        <div>
            <label>Pages:
                <form:input path="pages" type="number"/>
            </label>
            <form:errors path="pages" element="div" cssStyle="color:red"/>
        </div>
        <div>
            <label>Description:
                <form:textarea path="description" rows="3" cols="60"/>
            </label>
            <form:errors path="description" element="div" cssStyle="color:red"/>
        </div>
        <div>
            <label>Publisher:
                <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
            </label>
            <form:errors path="publisher" element="div" cssStyle="color:red"/>
        </div>
        <div>
            <label>Authors:
                <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/>
            </label>
            <form:errors path="authors" element="div" cssStyle="color:red"/>
        </div>
        <input type="submit" value="Save">

    </form:form>

</body>
</html>
