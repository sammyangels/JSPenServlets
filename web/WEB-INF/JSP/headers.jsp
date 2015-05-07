<%--@elvariable id="headers" type="be.vdab.servlets.headersservlet"--%>

<%-- Written by Samuel Engelen | Date: 29/04/2015 --%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url='/WEB-INF/JSP/head.jsp'>
        <c:param name='title' value="Pizza's" />
    </c:import>
</head>
<body>
<vdab:menu/>
<dl>
    <c:forEach var="h" items="${headers}">
        <dt>${h.key}</dt><dd>${h.value}</dd>
    </c:forEach>
</body>
</html>