<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration Page</title>
    <link href="css/registration.css" rel="stylesheet">
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
            <p>Панель регистрации</p>
            <div class="input_form_border">
                <form class="input_form" action="<%=Constants.REGISTRATION_CONTROLLER%>" method="post">
                    <label for="first_name">Введите Имя: </label>
                    <input id="first_name" class="form_input first_name" type="text" name="first_name">
                    <label for="last_name">Введите Фамилию: </label>
                    <input id="last_name" class="form_input last_name" type="text" name="last_name">
                    <label for="login">Введите Логин: </label>
                    <input id="login" class="form_input login" type="text" name="login">
                    <label for="password">Введите Пароль: </label>
                    <input id="password" class="form_input password" type="text" name="password">
                    <label for="email">Введите E-mail: </label>
                    <input id="email" class="form_input email" type="text" name="email">
                    <input class="registrationSubmit" type="submit" value="Зарегистрироваться">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
