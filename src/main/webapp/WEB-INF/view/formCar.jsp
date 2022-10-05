<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded/car"/>
<div class="col-2">
    <form action="${path}" method="get">
      <button class="btn btn-primary" type="submit">Back to Cars' List</button>
    </form>
  <br>
  <c:if test="${error != null}">
    <div class="alert alert-danger">
      <p>${error}</p>
    </div>
  </c:if>

  <h4>New Car</h4>
  <div class="portlet-body form">
    <form:form method="post" modelAttribute="newCar">
    <div class="form-body">

      <div class="form-group">
        <label for="licensePlate">License Plate</label>
        <form:input path="licensePlate" id="licensePlate" type="text" class="form-control" placeholder="License Plate"/>
        <form:errors path="licensePlate" cssClass="text-danger"/>
      </div>
      <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <form:input path="manufacturer" id="manufacturer" type="text" class="form-control" placeholder="Manufacturer"/>
        <form:errors path="manufacturer" cssClass="text-danger"/>
      </div>
      <div class="form-group">
        <label for="model">Model</label>
        <form:input path="model" id="model" type="text" class="form-control" placeholder="Model"/>
        <form:errors path="model" cssClass="text-danger"/>
      </div>
      <div class="form-group">
        <label for="typeName">Type Name</label>
        <form:input path="typeName" id="typeName" type="text" class="form-control" placeholder="Type Name"/>
        <form:errors path="typeName" cssClass="text-danger"/>
      </div>
      <div class="form-group">
        <label for="yearRegistration">Year Registration</label>
        <form:input path="yearRegistration" id="yearRegistration" type="date" class="form-control"/>
        <form:errors path="yearRegistration" cssClass="text-danger"/>
      </div>
      <br>
      <div class="form-actions">
        <form:input path="id" id="id" type="hidden"/>
        <button class="btn btn-primary form-buttons" type="submit">Submit</button>
      </div>

      </form:form>

    </div>
  </div>

</div>
