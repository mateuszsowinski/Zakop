<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Zakop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../styles/main.css">
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="" class="logo">
            <i class="fas fa-share-alt-square"></i>
            Zakop
        </a>
<%--        <a href="#" class="login-button">Zaloguj</a>--%>
        <c:choose>
            <c:when test="${sessionScope.userName == null}">
                <a href="${pageContext.request.contextPath}/login" class="login-button">Zaloguj</a>
            </c:when>
            <c:when test="${sessionScope.userName != null}">
                <a href="${pageContext.request.contextPath}/logout" class="login-button">Wyloguj</a>
            </c:when>
        </c:choose>
    </nav>


    <aside class="categories">
        <ul>
            <c:forEach items="${categories}" var="category">
                <li>  <a href='<c:url value="/category?id=${category.id}"/>'>${category.name}</a> </li>
            </c:forEach>

        </ul>
    </aside>