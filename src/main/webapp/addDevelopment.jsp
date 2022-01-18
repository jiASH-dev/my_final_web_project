<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
    <link href="css/addDevelopment.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="subpages/navbar.jsp"/>
<jsp:include page="subpages/instrumentPanel.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-xxl-12">
            <c:if test="${not empty message}">
                <p class="error_message">${message}</p>
            </c:if>
            <form id="add_form" class="add_form" method="post" action="<%=Constants.ADD_DEVELOPMENT_CONTROLLER%>">
                <input class="add_element" type="text" name="location"
                       placeholder="Введите место проведения">
                <input class="add_element" type="text" name="date"
                       placeholder="Введите дату проведения мероприятия">
                <input class="add_element" type="text" name="description"
                       placeholder="Введите краткое описание">
                <select class="add_element" name="<%=Constants.TYPE_PARAMETER_LABEL%>">
                    <option value="<%=Constants.CONFERENCE_LABEL%>">конференция</option>
                    <option value="<%=Constants.TRAINING_LABEL%>">тренинг</option>
                    <option value="<%=Constants.SEMINAR_LABEL%>">семинар</option>
                </select>
                <input class="add_element" id="buttonAddEvent" type="button" value="Добавить событие">
                <input class="add_element" type="submit">
            </form>
        </div>
    </div>
</div>
<script src="js/main.js"></script>
</body>
</html>
