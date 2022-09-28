<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded/user"/>

<div class="container col-3">
  <br>
  <h4>Change Password</h4>
  <c:if test="${param.error != null}">
    <div class="alert alert-danger">
      <p>Invalid Password</p>
    </div>
  </c:if>
  <div class="portlet-body form">
    <form method="post">
    <div class="form-body">
      <div class="form-group">
        <label for="oldPassword">Old Password</label>
        <input name="oldPassword" id="oldPassword" type="password" class="form-control" placeholder="Old Password"/>
      </div>
      <div class="form-group">
        <label for="newPassword">New Password</label>
        <input name="newPassword" id="newPassword" type="password" class="form-control" placeholder="New Password"/>
      </div>
      <br>
      <div class="form-actions">
        <button class="btn btn-primary form-buttons align-self-center" type="submit">Change Password</button>
      </div>

      </form>

    </div>
  </div>

</div>
