<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="<sring:url value='/js/user/actions.js'/>" type="text/javascript"></script>

<html>
<head>
    <title></title>
</head>
<body>
<%--<a href="${createController}">Создать</a>--%>

<c:forEach items="${userList}" var="user">
    <p>${user.firstName} ${user.lastName}<span
            class="deleteContact {id: ${user.id}}">(Удалить)</span></p>
</c:forEach>

<form action="/user/create" method="post">
    <label name="firstName">
        Имя
    </label>
    <input name="firstName"/>

    <label name="lastName">
        Фамилия
    </label>
    <input name="lastName"/>

    <hidden name="version"/>
    <button type="submit">Сохранить</button>
</form>

</body>
</html>