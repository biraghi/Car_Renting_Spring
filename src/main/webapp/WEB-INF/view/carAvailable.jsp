<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded"/>

<div>
    <h1>Auto Disponibili</h1>
    <br/>
    <div class="col-4">
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th scope="col">License Plate</th>
                <th scope="col">Manufacturer</th>
                <th scope="col">Model</th>
                <th scope="col">Type Name</th>
                <th scope="col">Year Registration</th>
                <th scope="col">Book</th>
            </tr>
            <c:forEach  var="car" items="${carBooked}">
                <tr>
                    <td>${car.licensePlate}</td>
                    <td>${car.manufacturer}</td>
                    <td>${car.model}</td>
                    <td>${car.typeName}</td>
                    <td>${car.yearRegistration}</td>
                    <td>
                        <form:form action="${path}/booking/add" method="post" modelAttribute="newBooking">
                            <form:hidden path="licensePlate" value="${car.licensePlate}"/>
                            <form:hidden path="startDate" value="${startDate}"/>
                            <form:hidden path="finishDate" value="${finishDate}"/>
                            <button type="submit" class="btn btn-primary">Book</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

