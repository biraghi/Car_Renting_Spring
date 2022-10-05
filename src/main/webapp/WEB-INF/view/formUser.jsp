<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<c:set var="path" value="http://localhost:8080/Car_Renting_Spring_war_exploded/user"/>
<div class="col-2">
    <form action="${path}" method="get">
        <button class="btn btn-primary" type="submit">Back to User's List</button>
    </form>
    <br>
    <c:if test="${error != null}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
    </c:if>


    <h4>New User</h4>
    <div class="portlet-body form">
        <form:form method="post" modelAttribute="newUser">
        <div class="form-body">

            <div class="form-group">
                <label for="firstname">Firstname</label>
                <form:input path="firstname" id="firstname" type="text" class="form-control" placeholder="Firstname"/>
                <form:errors path="firstname" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="lastname">Lastname</label>
                <form:input path="lastname" id="lastname" type="text" class="form-control" placeholder="Lastname"/>
                <form:errors path="lastname" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="birthdate">Birthdate</label>
                <form:input path="birthDate" id="birthdate" type="date" class="form-control"/>
                <form:errors path="birthDate" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <form:input path="username" id="username" type="text" class="form-control" placeholder="Username"/>
                <form:errors path="username" cssClass="text-danger"/>
            </div>
            <c:if test="${type.equals('add')}">
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input path="password" id="password" type="text" class="form-control" placeholder="Password"/>
                    <form:errors path="password" cssClass="text-danger"/>
                </div>
            </c:if>

            <c:if test="${!type.equals('add')}">
                <div class="form-group">
                    <form:input path="password" id="password" type="hidden" class="form-control" placeholder="Password"/>
                </div>
            </c:if>

            <br>
            <div class="form-actions">
                <form:input path="id" id="id" type="hidden"/>
                <button class="btn btn-primary form-buttons" type="submit">Submit</button>
            </div>

            </form:form>

        </div>
    </div>

</div>
