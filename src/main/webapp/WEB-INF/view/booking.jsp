<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>


<div>

  <h1>Booking</h1></br>
  <div class="col-4">
      <a href="./add/" class="btn btn-primary">New Booking</a>
    <table class="table table-striped table-bordered table-sm">
      <tr>
        <th scope="col">User Username</th>
        <th scope="col">Car License Plate</th>
        <th scope="col">Start Date</th>
        <th scope="col">Finish Date</th>
        <th scope="col">Approve</th>
        <th scope="col">Delete</th>
      </tr>
      <c:forEach  var="booking" items="${bookingList}">
        <tr>
          <td>${booking.user.username}</td>
          <td>${booking.car.licensePlate}</td>

          <fmt:parseDate  var="startDate" pattern = "yyyy-MM-dd" value = "${booking.startDate}"/>
          <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${startDate}" /></td>
          <fmt:parseDate  var="finishDate" pattern = "yyyy-MM-dd" value = "${booking.finishDate}"/>
          <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${finishDate}" /></td>

          <c:if test="${booking.approve == false}">
            <td>NO</td>
          </c:if>
          <c:if test="${booking.approve == true}">
            <td>YES</td>
          </c:if>

          <td>
            <a href="./delete/${booking.id}" class="btn btn-primary">Delete</a>
          </td>

        </tr>
      </c:forEach>
    </table>
  </div>
</div>
