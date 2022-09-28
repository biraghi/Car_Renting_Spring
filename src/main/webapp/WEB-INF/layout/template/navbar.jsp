<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html xml:lang="en">
<head>
    <c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <script src="${path}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <script src="${path}/webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" type="text/css" href="${path}/webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
    <title><tiles:insertAttribute name="titolo"/></title>
</head>
<body>
<div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${path}/">Car Renting</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li><a class="nav-link" href="${path}/login?logout">Logout</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="${path}/dati" role="button" data-bs-toggle="dropdown">Database</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${path}/user">Users</a></li>
                            <li><a class="dropdown-item" href="${path}/car">Cars</a></li>
                            <li><a class="dropdown-item" href="${path}/booking">Bookings</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <form class="d-flex justify-content-end">
                <security:authorize access="isAuthenticated()">
                    <a class="navbar-brand" href="${path}/profile">
                        <span class="bi-person"></span>
                            ${sessionScope.userLogged.firstname} ${sessionScope.userLogged.lastname}
                    </a>
                </security:authorize>
            </form>
        </div>
    </nav>
</div>
<br>
<tiles:insertAttribute name="content"/>
</body>
</html>
