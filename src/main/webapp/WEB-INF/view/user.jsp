<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="true" %>


<div>
    <h1>Users</h1>
    <br>
    <div class="col-4">
        <a href="./user/add" class="btn btn-primary">New User</a>
        <table class="table table-striped table-bordered table-sm">
            <caption>Users'List</caption>
            <tr>
                <th scope="col">Firstname</th>
                <th scope="col">Lastname</th>
                <th scope="col">Username</th>
                <th scope="col">Birthdate</th>
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>

            </tr>
            <c:forEach  var="user" items="${userList}">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                    <fmt:parseDate  var="birthDate" pattern = "yyyy-MM-dd" value = "${user.birthDate}"/>
                    <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${birthDate}" /></td>
                    <td>
                        <a href="./user/update/${user.id}" class="btn btn-primary">Update</a>
                    </td>
                    <td>
                        <a href="./user/delete/${user.id}" class="btn btn-primary">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
