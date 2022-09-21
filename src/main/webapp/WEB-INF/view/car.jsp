<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>


<div class="row">
  <h1>Cars</h1></br>
  <div class="col-4">
    <c:if test="${sessionScope.login.admin == true}">
      <form action="CarServlet" method="get">
        <input type="hidden" name="typeGet" value="addCar">
        <button class="btn btn-primary" type="submit">New Car</button>
      </form>
    </c:if>
    <table class="table table-striped table-bordered table-sm">
      <tr>
        <th scope="col">License Plate</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Model</th>
        <th scope="col">Type Name</th>
        <th scope="col">Year Registration</th>
        <c:if test="${sessionScope.login.admin == true}">
          <th scope="col">Update</th>
          <th scope="col">Delete</th>
        </c:if>
      </tr>
      <c:forEach  var="car" items="${carList}">
        <tr>
          <td>${car.licensePlate}</td>
          <td>${car.manufacturer}</td>
          <td>${car.model}</td>
          <td>${car.typeName}</td>
          <td>${car.yearRegistration}</td>
          <c:if test="${sessionScope.login.admin == true}">
            <td>
              <form action="CarServlet" method="get">
                <input type="hidden" name="typeGet" value="updateCar">
                <input type="hidden" name="id" value="${car.id}">
                <button class="btn btn-primary" type="submit">Update</button>
              </form>
            </td>
            <td>
              <form action="CarServlet" method="get">
                <input type="hidden" name="typeGet" value="deleteCar">
                <input type="hidden" name="id" value="${car.id}">
                <button class="btn btn-primary" type="submit">Delete</button>
              </form>
            </td>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

