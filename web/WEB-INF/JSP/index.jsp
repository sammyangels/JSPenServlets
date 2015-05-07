<%--@elvariable id="aantalKeerBekeken" type="be.vdab.servlets.indexservlet"--%>
<%--@elvariable id="begroeting" type="be.vdab.servlets.indexservlet"--%>
<%--@elvariable id="zaakvoerder" type="be.vdab.servlets.indexservlet"--%>
<%--@elvariable id="nu" type="be.vdab.servlets.indexservlet"--%>
<%--@elvariable id="aantalPizzasVerkocht" type="be.vdab.servlets.indexservlet"--%>

<%-- Written by Samuel Engelen | Date: 21/04/2015 --%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang="nl">
    <head>
        <c:import url="/WEB-INF/JSP/head.jsp" >
            <c:param name="title" value="Pizza Luigi"/>
        </c:import>
    </head>
    <body>
    <c:import url='/WEB-INF/JSP/menu.jsp'/>
        <h1>Pizza Luigi</h1>
        <img src="<c:url value="/images/pizza.jpg"/>" alt="pizza" class="fullwidth"/>
        <h2>${begroeting}</h2>
        <br/>
        <h2>De zaakvoerder</h2>
        <dl>
            <dt>Vandaag</dt><dd>
            <fmt:formatDate value="${nu}" type="date" dateStyle="long"/></dd>
            <dt>Aantal pizza's verkocht</dt>
            <dd><fmt:formatNumber value='${aantalPizzasVerkocht}'/></dd>
            <dt>Naam</dt><dd>${zaakvoerder.naam}</dd>
            <dt>Aantal kinderen</dt><dd>${zaakvoerder.aantalKinderen}</dd>
            <dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee'}</dd>
            <%--<dt>Adres</dt>--%>
            <%--<dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisNr}<br>--%>
                <%--${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>--%>
        </dl>
    <div>Deze pagina werd ${aantalKeerBekeken} keer bekeken.</div>
    </body>
</html>