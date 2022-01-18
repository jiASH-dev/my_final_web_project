<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome Page</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="/subpages/navbar.jsp"/>
<div class="container greeting_container">
    <div class="row">
        <div class="col-xxl-12 greeting_text">
            <p class="greeting_paragraph">Добро пожаловать !</p>
            <p class="greeting_paragraph">Здесь содержатся разделы,
                представляющие
                информацию о существующих
                мероприятиях.</p>
            <p class="greeting_paragraph">Вы можете воспользоваться представленными ниже ссылками:</p>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row sections_row">
        <div class="col-xxl-2 info_block">
            <p class="section_info">Сегодня</p>
            <button class="section_button today image" form="sections" name="choose" value="today"></button>
        </div>
        <div class="col-xxl-2 info_block">
            <p class="section_info">Завтра</p>
            <button class="section_button tomorrow image" form="sections" name="choose" value="tomorrow"></button>
        </div>
        <div class="col-xxl-2 info_block">
            <p class="section_info">Скоро</p>
            <button class="section_button soon image" form="sections" name="choose" value="soon"></button>
        </div>
        <div class="col-xxl-2 info_block">
            <p class="section_info">Прошедшие</p>
            <button class="section_button past image" form="sections" name="choose" value="past"></button>
        </div>
        <div class="col-xxl-2 info_block">
            <p class="section_info">Все</p>
            <button class="section_button all image" form="sections" name="choose" value="all"></button>
        </div>
        <form id="sections" method="get" action="<%=Constants.SHOW_DEVELOPMENT_CONTROLLER%>"></form>
    </div>
</div>
</body>
</html>
