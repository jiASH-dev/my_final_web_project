<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/personal_cabinet_start.css" rel="stylesheet" type="text/css">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
</head>
<body>
<c:import url="subpages/navbar.jsp"/>
<c:import url="subpages/instrumentPanel.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-xxl-12 start_info_block">
                <p>Добро пожаловать в личный кабинет !</p>
                <p>Вы можете воспользоваться функциями,
                представленными на левой боковой панели</p>
            </div>
        </div>
    </div>
</body>
</html>
