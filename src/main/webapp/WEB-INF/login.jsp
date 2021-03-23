<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Zaloguj</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;600&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="/styles/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/styles/form.css"/>" rel="stylesheet">

</head>
<body>
<form action="/login" method="post" class="user-form">
    <h2 class="user-form-title">Zaloguj</h2>
    <input name="loginUsername" type="text" placeholder="Login" required>
    <input name="loginPassword" type="password" placeholder="Hasło" required>
    <button class="user-form-button">Zaloguj</button>
    <p> Nie masz konta? <a href="/signup">Zarejestruj się</a></p>

</form>

</body>
</html>

