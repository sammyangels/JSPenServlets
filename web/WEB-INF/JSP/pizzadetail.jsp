<%--@elvariable id="pizza" type="be.vdab.entities.Pizza"--%>
<%--@elvariable id="fout" type="be.vdab.servlets.PizzaDetailServlet"--%>

<%-- Written by Samuel Engelen | Date: 28/04/2015 --%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
    <head>
        <c:import url="/WEB-INF/JSP/head.jsp">
            <c:param name="title" value="${pizza.naam}"/>
        </c:import>
    </head>
    <body>
        <c:import url="menu.jsp"/>
        <c:choose>
            <c:when test="${empty pizza}">
                    <div class="fout">${empty fout ? "Pizza niet gevonden" : fout}</div>
            </c:when>
            <c:otherwise>
                <h1>${pizza.naam}</h1>
                <dl>
                    <dt>Nummer</dt><dd>${pizza.id}</dd>
                    <dt>Naam</dt><dd>${pizza.naam}</dd>
                    <dt>Prijs</dt><dd>${pizza.prijs}</dd>
                    <dt>Pikant</dt><dd>${pizza.pikant ? 'ja' : 'nee'}</dd>
                </dl>
            </c:otherwise>
        </c:choose>
    </body>
</html>