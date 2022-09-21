<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
    <title>Car Renting</title>
</head>
<body>
<c:if test="${sessionScope.login.admin}">
    <c:set var="ad" scope="page" value="Admin"></c:set>
</c:if>
<c:if test="${!sessionScope.login.admin}">
    <c:set var="ad" scope="page" value="Customer"></c:set>
</c:if>
<div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/Car_Renting_war_exploded/index.jsp">Car Renting</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li><a class="nav-link" href="LoginServlet?typeGet=logout">Logout</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Database</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="user-servlet?typeGet=getUsers">Users</a></li>
                            <li><a class="dropdown-item" href="CarServlet?typeGet=getCars">Cars</a></li>
                            <li><a class="dropdown-item" href="BookingServlet?typeGet=getBookings">Bookings</a></li>
                        </ul>
                    </li>
                    <li><a class='nav-link text-light'><c:out value="Bentornato ${sessionScope.login.firstname} ${sessionScope.login.lastname}(${ad})"></c:out></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<br>

<h1>Car Renting</h1>
<br/>
<form action="dati.jsp" method="get">
    <button class="btn btn-primary" type="submit">Database</button>
</form>
<br><br>
<form action="rangeData.jsp" method="get">
    <button class="btn btn-primary" type="submit">Auto Disponibili</button>
</form>
</body>
</html>