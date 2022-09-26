<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<div class="col-2">
    <form action="./booking/" method="get">
      <button class="btn btn-primary" type="submit">Back to Bookings' List</button>
    </form>
  <br>


  <h4>New Booking</h4>
  <div class="portlet-body form">
    <form:form method="post" modelAttribute="newBooking">
    <div class="form-body">

      <div class="form-group">
        <label for="username">User Username</label>
        <form:select path="username" id="username" class="form-select">
          <form:option selected="true" value="Select Username"></form:option>
          <form:options items="${usernameList}"/>
        </form:select>
      </div>
      <div class="form-group">
        <label for="licensePlate">License Plate</label>
        <form:select path="licensePlate" id="licensePlate" class="form-select">
          <form:option selected="true" value="Select License Plate"></form:option>
          <form:options items="${licensePlateList}"/>
        </form:select>
      </div>
      <div class="form-group">
        <label for="startDate">Start Date</label>
        <form:input path="startDate" id="startDate" type="date" class="form-control"/>
      </div>
      <div class="form-group">
        <label for="finishDate">Finish Date</label>
        <form:input path="finishDate" id="finishDate" type="date" class="form-control"/>
      </div>
      <br>
      <div class="form-actions">
        <button class="btn btn-primary form-buttons" type="submit">Submit</button>
      </div>

      </form:form>

    </div>
  </div>

</div>
