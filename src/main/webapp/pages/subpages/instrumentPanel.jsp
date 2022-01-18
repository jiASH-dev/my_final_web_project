<%@ page import="by.jiash.Constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/instrumentPanel.css" type="text/css" rel="stylesheet">
    <link href="../css/normalize.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="flex_instruments">
    <form class="instrument_col" method="get" action="<%=Constants.SHOW_DEVELOPMENT_MAPPING%>">
        <button class="self instrument_button" id="self_button" name="section" value="SELF"></button>
    </form>
    <form class="instrument_col" method="post" action="<%=Constants.ADD_DEVELOPMENT_MAPPING%>">
        <button class="add instrument_button"></button>
    </form>
    <form class="instrument_col" method="post" action="<%=Constants.EDIT_PANEL_MAPPING%>">
        <button class="settings instrument_button"></button>
    </form>
</div>
</body>
</html>
