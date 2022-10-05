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
        <form:form method="post" modelAttribute="passwordChange">
            <div class="form-body">
                <div class="form-group">
                    <label for="oldPassword">Old Password</label>
                    <form:input path="oldPassword" id="oldPassword" type="password" class="form-control"
                                placeholder="Old Password"/>
                    <form:errors path="oldPassword" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="newPassword">New Password</label>
                    <form:input path="newPassword" id="newPassword" type="password" class="form-control"
                                placeholder="New Password"/>
                    <form:errors path="newPassword" cssClass="text-danger"/>
                </div>
                <br>
                <div class="form-actions">
                    <button class="btn btn-primary form-buttons align-self-center" type="submit">Change Password
                    </button>
                </div>

            </div>
        </form:form>

    </div>
</div>

