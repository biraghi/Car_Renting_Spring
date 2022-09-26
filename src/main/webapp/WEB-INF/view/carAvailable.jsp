<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

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
            </tr>
            <c:forEach  var="car" items="${carBooked}">
                <tr>
                    <td>${car.licensePlate}</td>
                    <td>${car.manufacturer}</td>
                    <td>${car.model}</td>
                    <td>${car.typeName}</td>
                    <td>${car.yearRegistration}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

