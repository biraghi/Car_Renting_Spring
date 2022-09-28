<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="true" %>


<div>
    <h1>Users</h1>
    <br>
    <div class="col-4">
        <security:authorize access="hasRole('ADMIN')">
            <a href="./user/add" class="btn btn-primary">New User</a>
        </security:authorize>
        <table class="table table-striped table-bordered table-sm">
            <caption>Users'List</caption>
            <tr>
                <th scope="col">Firstname</th>
                <th scope="col">Lastname</th>
                <th scope="col">Username</th>
                <th scope="col">Birthdate</th>
                <security:authorize access="hasRole('ADMIN')">
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </security:authorize>


            </tr>
            <c:forEach  var="user" items="${userList}">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                    <fmt:parseDate  var="birthDate" pattern = "yyyy-MM-dd" value = "${user.birthDate}"/>
                    <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${birthDate}" /></td>
                    <security:authorize access="hasRole('ADMIN')">
                        <td>
                            <a href="./update/${user.id}" class="btn btn-primary">Update</a>
                        </td>
                        <td>
                            <a href="./delete/${user.id}" class="btn btn-primary">Delete</a>
                        </td>
                    </security:authorize>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
