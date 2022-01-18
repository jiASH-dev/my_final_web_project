<%@ page import="Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="css/developmentsInfo.css" rel="stylesheet" type="text/css">
    <link href="css/normalize.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<c:import url="subpages/navbar.jsp"/>
<c:if test="${not empty developmentMap}">
    <div class="container">
        <c:forEach items="${developmentMap}" var="item">
            <div class="row table_row">
                <div class="col-xxl-7">
                    <p class="development_type">${item.key}S:</p>
                    <table class="developments_table">
                        <tr>
                            <th class="table_element">Руководитель</th>
                            <th class="table_element">Место проведения</th>
                            <th class="table_element">Дата проведения</th>
                            <th class="table_element">Статус</th>
                            <th class="table_element">Краткое описание</th>
                            <th class="table_element">Дополнительно</th>
                        </tr>
                        <c:forEach items="${item.value}" var="listItem">
                            <tr>
                                <td class="table_element">${listItem.owner.firstName} ${listItem.owner.lastName}</td>
                                <td class="table_element">${listItem.location}</td>
                                <td class="table_element">${listItem.date}</td>
                                <td class="table_element">${listItem.passed}</td>
                                <td class="table_element">${listItem.description}</td>
                                <td class="table_element">
                                    <button form="additionally" name="developmentId" value="${listItem.id}">
                                        Перейти
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </c:forEach>
        <form id="additionally" method="post" action="<%=Constants.SHOW_DEVELOPMENT_DETAILS_CONTROLLER%>">
            <input type="hidden" name="return_url" value="<%=Constants.ANY_DEVELOPMENTS_INFO_URL%>">
        </form>
    </div>
</c:if>
<c:if test="${not empty developmentDetails}">
    <div class="container">
        <div class="row table_row">
            <div class="col-xxl-3">
                <table class="developments_table">
                    <tr>
                        <th class="table_element">Название события</th>
                        <th class="table_element">Время начала</th>
                        <th class="table_element">Время окончания</th>
                    </tr>
                    <c:forEach items="${developmentDetails}" var="entry">
                        <tr>
                            <td class="table_element">${entry.key}</td>
                            <c:forEach items="${entry.value}" var="time">
                                <td class="table_element">${time}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${not empty message}">
    <p class="error_message">${message}</p>
</c:if>
</body>
</html>
