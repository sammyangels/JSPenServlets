<%-- Written by Samuel Engelen | Date: 28/04/2015 --%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="head.jsp">
        <c:param name="title" value="Voorkeurpizza's"/>
    </c:import>
</head>
<body>
    <c:import url="menu.jsp"/>
        <h1>Voorkeurpizza's</h1>
    <form>
        <ul class="zonderbolletjes">
            <%--@elvariable id="pizzas" type="be.vdab.servlets.voorkeurpizzasservlet"--%>
            <c:forEach var="pizza" items="${pizzas}">
                <li>
                    <label><input type="checkbox" name="id" value="${pizza.id}">
                    <c:out value="${pizza.naam}"/></label>
                </li>
            </c:forEach>
        </ul>
        <input type="submit" value="Toon mijn keuzes">
    </form>
    <%--@elvariable id="voorkeurPizzas" type="be.vdab.servlets.voorkeurpizzasservlet"--%>
    <c:if test="${not empty voorkeurPizzas}">
        <h1>Je voorkeurpizza's</h1>
        <ul class="zebra">
            <c:forEach var="pizza" items="${voorkeurPizzas}">
                <li><c:out value="${pizza.naam}"/></li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>