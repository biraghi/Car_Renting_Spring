<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>


<div>

  <h1>Booking</h1></br>
  <div class="col-4">
    <c:if test="${sessionScope.login.admin == false}">
      <form action="BookingServlet" method="get">
        <input type="hidden" name="typeGet" value="addBooking">
        <button class="btn btn-primary" type="submit">New Booking</button>
      </form>
    </c:if>
    <table class="table table-striped table-bordered table-sm">
      <tr>
        <th scope="col">User Username</th>
        <th scope="col">Car License Plate</th>
        <th scope="col">Start Date</th>
        <th scope="col">Finish Date</th>
        <th scope="col">Approve</th>
        <c:if test="${sessionScope.login.admin == true}">
          <th scope="col">Delete</th>
        </c:if>
      </tr>
      <c:forEach  var="booking" items="${bookingList}">
        <tr>
          <td>${booking.user.username}</td>
          <td>${booking.car.licensePlate}</td>
          <td>${booking.startDate}</td>
          <td>${booking.finishDate}</td>
          <c:if test="${sessionScope.login.admin == true}">
            <c:if test="${booking.approve == false}">
              <td>
                <form action="BookingServlet" method="get">
                  <input type="hidden" name="typeGet" value="approveBooking">
                  <input type="hidden" name="id" value="${booking.id}">
                  <button class="btn btn-primary" type="submit">Approve</button>
                </form>
              </td>
            </c:if>
            <c:if test="${booking.approve == true}">
              <td>YES</td>
            </c:if>
            <td>
              <form action="BookingServlet" method="get">
                <input type="hidden" name="typeGet" value="deleteBooking">
                <input type="hidden" name="id" value="${booking.id}">
                <button class="btn btn-primary" type="submit">Delete</button>
              </form>
            </td>
          </c:if>
          <c:if test="${sessionScope.login.admin == false}">
            <c:if test="${booking.approve == false}">
              <td>NO</td>
            </c:if>
            <c:if test="${booking.approve == true}">
              <td>YES</td>
            </c:if>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
