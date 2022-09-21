<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<div class="col-2">
    <form action="./user/" method="get">
      <button class="btn btn-primary" type="submit">Back to User's List</button>
    </form>
  <br>


  <h4>New User</h4>
  <div class="portlet-body form">
    <form:form method="post" modelAttribute="newUser">
    <div class="form-body">

      <div class="form-group">
        <label for="firstname">Firstname</label>
        <form:input path="firstname" id="firstname" type="text" class="form-control" placeholder="Firstname"></form:input>
      </div>
      <div class="form-group">
        <label for="lastname">Lastname</label>
        <form:input path="lastname" id="lastname" type="text" class="form-control" placeholder="Lastname"></form:input>
      </div>
      <div class="form-group">
        <label for="birthdate">Birthdate</label>
        <form:input path="birthDate" id="birthdate" type="date" class="form-control"></form:input>
      </div>
      <div class="form-group">
        <label for="username">Username</label>
        <form:input path="username" id="username" type="text" class="form-control" placeholder="Username"></form:input>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <form:input path="password" id="password" type="text" class="form-control" placeholder="Password"></form:input>
      </div>
      <br>
      <div class="form-actions">
        <button class="btn btn-primary form-buttons" type="submit">Submit</button>
      </div>

      </form:form>

    </div>
  </div>

</div>
