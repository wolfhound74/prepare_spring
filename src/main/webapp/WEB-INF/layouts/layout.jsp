<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sring" uri="http://www.springframework.org/tags" %>
<script src="<sring:url value='/js/jquery/jquery-1.9.0.js'/>" type="text/javascript"></script>
<script src="<sring:url value='/js/jquery/jquery-ui-1.10.0.custom.js'/>" type="text/javascript"></script>
<html>
<head>
    <%--<title><tiles:insertAttribute name="title" ignore="true" /></title>--%>
</head>
<body>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>

</body>
</html>