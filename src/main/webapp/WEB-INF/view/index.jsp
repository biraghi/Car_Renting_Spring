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
    <a href="./car/available/" class="btn btn-primary">Car Available</a>
</div>

