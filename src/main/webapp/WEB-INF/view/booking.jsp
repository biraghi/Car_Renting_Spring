<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded"/>


<div>

  <h1>Booking</h1></br>
  <div class="col-4">
    <security:authorize access="hasRole('USER')">
      <a href="${path}/car/available" class="btn btn-primary">New Booking</a>
    </security:authorize>

    <table class="table table-striped table-bordered table-sm">
      <tr>
        <th scope="col">User Username</th>
        <th scope="col">Car License Plate</th>
        <th scope="col">Start Date</th>
        <th scope="col">Finish Date</th>
        <th scope="col">Approve</th>
        <security:authorize access="hasRole('ADMIN')">
          <th scope="col">Delete</th>
        </security:authorize>
      </tr>
      <c:forEach  var="booking" items="${bookingList}">
        <tr>
          <td>${booking.user.username}</td>
          <td>${booking.car.licensePlate}</td>

          <fmt:parseDate  var="startDate" pattern = "yyyy-MM-dd" value = "${booking.startDate}"/>
          <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${startDate}" /></td>
          <fmt:parseDate  var="finishDate" pattern = "yyyy-MM-dd" value = "${booking.finishDate}"/>
          <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${finishDate}" /></td>
          <security:authorize access="hasRole('USER')">
            <c:if test="${booking.approve == false}">
              <td>NO</td>
            </c:if>
            <c:if test="${booking.approve == true}">
              <td>YES</td>
            </c:if>
          </security:authorize>

          <security:authorize access="hasRole('ADMIN')">
            <c:if test="${booking.approve == false}">
              <td>
                <a href="./booking/approve/${booking.id}" class="btn btn-primary">Approve</a>
              </td>
            </c:if>
            <c:if test="${booking.approve == true}">
              <td>YES</td>
            </c:if>
          </security:authorize>

          <security:authorize access="hasRole('ADMIN')">
            <td>
              <a href="./delete/${booking.id}" class="btn btn-primary">Delete</a>
            </td>
          </security:authorize>


        </tr>
      </c:forEach>
    </table>
  </div>
</div>
