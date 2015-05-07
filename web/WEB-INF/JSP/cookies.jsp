<%--@elvariable id="naam" type="be.vdab.servlets.cookieservlet"--%>
<%-- Written by Samuel Engelen | Date: 29/04/2015 --%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url='/WEB-INF/JSP/head.jsp'>
        <c:param name='title' value='Cookies'/>
    </c:import>
</head>
<body>
<c:import url='/WEB-INF/JSP/menu.jsp' />
<h1>Cookies</h1>
<form method='post'>
    <label>Naam<input name='naam' value='${naam}' autofocus/></label>
    <input type='submit' value='Onthoud me'>
</form>
</body>
</html>