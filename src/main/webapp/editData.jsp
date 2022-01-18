<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="css/editData.css" rel="stylesheet" type="text/css">
    <link href="css/instrumentPanel.css" rel="stylesheet" type="text/css">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<c:import url="subpages/instrumentPanel.jsp"/>
<c:import url="subpages/navbar.jsp"/>
<c:choose>
    <c:when test="${not empty type}">
        <div class="container">
            <div class="row edit_row">
                <div class="col-xxl-4">
                    <form method="post" action="<%=Constants.EDIT_INFO_CONTROLLER%>">
                        <input type="text" name="edited_property">
                        <input type="hidden" name="type" value="${type}">
                        <input type="submit">
                    </form>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container edit_container">
            <div class="row edit_row">
                <div class="col-xxl-4 edit_box">
                    <p>Панель редактирования</p>
                    <table class="edit_table">
                        <tr>
                            <td class="edit_element">Логин</td>
                            <td class="edit_element">${user.login}</td>
                        </tr>
                        <tr>
                            <td class="edit_element">Имя</td>
                            <td class="edit_element">${user.firstName}</td>
                            <td class="edit_element">
                                <button form="edit_form" name="type" value="first_name">Редактировать</button>
                            </td>
                        </tr>
                        <tr>
                            <td class="edit_element">Фамилия</td>
                            <td class="edit_element">${user.lastName}</td>
                            <td class="edit_element">
                                <button form="edit_form" name="type" value="last_name">Редактировать</button>
                            </td>
                        </tr>
                        <tr>
                            <td class="edit_element">Email</td>
                            <td class="edit_element">${user.email}</td>
                            <td class="edit_element">
                                <button form="edit_form" name="type" value="email">Редактировать</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <form id="edit_form" method="post" action="<%=Constants.TYPE_SPECIFIER_CONTROLLER%>"></form>
    </c:otherwise>
</c:choose>
</body>
</html>
