<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<div>
    <h1>Car Renting</h1>
    <br/>
    <form action="./dati" method="get">
        <button class="btn btn-primary" type="submit">Database</button>
    </form>
    <br><br>
    <form action="rangeData.jsp" method="get">
        <button class="btn btn-primary" type="submit">Auto Disponibili</button>
    </form>
</div>

