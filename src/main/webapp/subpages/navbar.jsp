<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="../css/navbar.css" rel="stylesheet" type="text/css">
    <link href="../css/normalize.css" type="text/css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container-fluid navbar_container-fluid">
    <div class="row navbar_row">
        <div class="col-xxl-5 offset-xxl-7">
            <nav>
                <ul>
                    <c:choose>
                        <c:when test="${not empty user}">
                            <li>
                               <p class="logged_as">Вы вошли, как ${user.login}</p>
                            </li>
                            <li>
                                <a href="../personal_cabinet_start.jsp">Личный кабинет</a>
                            </li>
                            <li>
                                <a href="../index.jsp">Главное меню</a>
                            </li>
                            <li>
                                <form class="logOut_form" method="post" action="<%=Constants.LOGOUT_CONTROLLER%>">
                                    <input class="logOut" type="submit" value="Выйти">
                                </form>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="../logIn.jsp">Войти</a>
                            </li>
                            <li>
                                <a href="../registration.jsp">Регистрация</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
