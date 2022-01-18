<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="css/logIn.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container input_container">
    <div class="row input_row">
        <div class="col-xxl-6">
            <c:if test="${not empty message}">
                <p class="error_message">${message}</p>
            </c:if>
            <p>Панель авторизации</p>
            <div class="input_form_border">
                <form class="input_form" action="<%=Constants.LOGIN_CONTROLLER%>" method="post">
                    <label for="login">Введите логин: </label>
                    <input class="form_input login" id="login" type="text" name="login">
                    <label for="password">Введите пароль: </label>
                    <input class="form_input password" id="password" type="text" name="password">
                    <input class="form_input" type="submit" value="Войти">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
