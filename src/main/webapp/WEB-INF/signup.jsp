<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Zarejestruj się</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;600&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/main.css">
    <link rel="stylesheet" href="../styles/form.css">
    <link href="<c:url value="/styles/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/styles/form.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="#" class="logo">
            <i class="fas fa-share-alt-square"></i>
            Zakop
        </a>
        <a href="#" class="login-button">Zaloguj</a>
    </nav>

    <form method="post" action="/signup" class="user-form">
        <h2 class="user-form-title">Zarejestruj się</h2>
        <input name="username" type="text" placeholder="Nazwa użytkownika" required>
        <input name="email" type="email" placeholder="Adres e-mail" required>
        <input name="password" type="password" placeholder="Hasło" required>
        <button class="user-form-button">Zarejestruj</button>
    </form>

</div>
</body>
</html>
