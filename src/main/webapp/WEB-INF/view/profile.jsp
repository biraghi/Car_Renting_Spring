<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded/user"/>

<div class="container col-3">
  <br>
  <h4>Bentornato ${sessionScope.userLogged.firstname} ${sessionScope.userLogged.lastname}</h4>
  <c:if test="${param.success != null}">
    <div class="alert alert-success">
      <p>Save Success</p>
    </div>
  </c:if>
  <c:if test="${param.succPass != null}">
    <div class="alert alert-success">
      <p>Change Password Success</p>
    </div>
  </c:if>
  <div class="portlet-body form">
    <form:form method="post" modelAttribute="userProfile">
    <div class="form-body">

      <div class="form-group">
        <label for="firstname">Firstname</label>
        <form:input path="firstname" id="firstname" type="text" class="form-control" placeholder="Firstname"/>
      </div>
      <div class="form-group">
        <label for="lastname">Lastname</label>
        <form:input path="lastname" id="lastname" type="text" class="form-control" placeholder="Lastname"/>
      </div>
      <div class="form-group">
        <label for="birthdate">Birthdate</label>
        <form:input path="birthDate" id="birthdate" type="date" class="form-control"/>
      </div>
      <div class="form-group">
        <label for="username">Username</label>
        <form:input path="username" id="username" type="text" class="form-control" placeholder="Username"/>
      </div>
      <br>
      <div class="form-actions">
        <form:input path="id" id="id" type="hidden"/>
        <a class="btn btn-primary form-buttons" href="./profile/password">Change Password</a>
        <button class="btn btn-primary form-buttons offset-md-4" type="submit">Save</button>
      </div>

      </form:form>

    </div>
  </div>

</div>
