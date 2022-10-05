<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>


<div class="row">
  <h1>Cars</h1></br>
  <div class="col-4">
    <security:authorize access="hasRole('ADMIN')">
    <a href="./car/add/" class="btn btn-primary">New Car</a>
    </security:authorize>
    <table class="table table-striped table-bordered table-sm">
      <tr>
        <th scope="col">License Plate</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Model</th>
        <th scope="col">Type Name</th>
        <th scope="col">Year Registration</th>
        <security:authorize access="hasRole('ADMIN')">
          <th scope="col">Update</th>
          <th scope="col">Delete</th>
        </security:authorize>
      </tr>
      <c:forEach  var="car" items="${carList}">
        <tr>
          <td>${car.licensePlate}</td>
          <td>${car.manufacturer}</td>
          <td>${car.model}</td>
          <td>${car.typeName}</td>
          <fmt:parseDate  var="yearRegistration" pattern = "yyyy-MM-dd" value = "${car.yearRegistration}"/>
          <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${yearRegistration}" /></td>
          <security:authorize access="hasRole('ADMIN')">
          <td>
            <a href="./car/update/${car.id}" class="btn btn-primary">Update</a>
          </td>
          <td>
            <a href="./car/delete/${car.id}" class="btn btn-primary">Delete</a>
          </td>
          </security:authorize>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

