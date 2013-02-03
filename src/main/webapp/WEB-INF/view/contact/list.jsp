<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="createController" value="/contact/create" />

<html>
<head>
    <title></title>
</head>
<body>
<a href="${createController}">Создать</a>

<c:forEach items="${contactList}" var="contact">
    <p>${contact.firstName} ${contact.lastName}</p>
</c:forEach>


</body>
</html>