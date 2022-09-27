<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html xml:lang="en">
<head>
  <c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded"/>
  <script src="${path}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="${path}/webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
  <link rel="stylesheet" type="text/css" href="${path}/webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
  <title><tiles:insertAttribute name="titolo"/></title>
</head>
<body>
  <div class="container col-3">
    <c:url var="loginUrl" value="/login" />
    <form class="form-signin" method="post" action="${loginUrl}">
      <h2 class="form-signin-heading">Login</h2>

      <c:if test="${param.error != null}">
        <div class="alert alert-danger">
          <p>Error</p>
        </div>
      </c:if>

      <c:if test="${param.logout != null}">
        <div class="alert alert-success">
          <p>Logout Success</p>
        </div>
      </c:if>

      <p>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
      </p>
      <p>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus>
      </p>
      <button class="btn btn-primary btn-lg btn-block" type="submit">Sign in</button>
    </form>
  </div>
</body>
</html>