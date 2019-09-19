<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 17.09.19
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a book '" + title + "'?")) {
                window.location.href = "/books/delete/" + id;
            }
        }

    </script>
</head>
<body>
    <div>
        <a href="/books/add">Dodaj książkę</a>
    </div>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Publisher</th>
            <th>Author</th>
            <th>links</th>
            <th>links2</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.publisher.name}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        ${author.fullName},
                    </c:forEach>
                </td>
                <td><a href="/books/update/${book.id}">Update</a></td>
                <td><a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">Delete</a></td>
                <!-- bo ten book.id to liczba -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
