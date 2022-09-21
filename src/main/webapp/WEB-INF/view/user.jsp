<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>


<div>
    <h1>Users</h1>
    <br>
    <div class="col-4">
        <c:if test="${sessionScope.login.admin == true}">
        <form action="user-servlet" method="get">
            <input type="hidden" name="typeGet" value="addUser">
            <button class="btn btn-primary" type="submit">New User</button>
        </form>
        </c:if>
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th scope="col">Firstname</th>
                <th scope="col">Lastname</th>
                <th scope="col">Username</th>
                <th scope="col">Birthdate</th>
                <c:if test="${sessionScope.login.admin == true}">
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </c:if>

            </tr>
            <c:forEach  var="user" items="${userList}">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                    <td>${user.birthDate}</td>
                    <c:if test="${sessionScope.login.admin == true}">
                    <td>
                        <form action="user-servlet" method="get">
                            <input type="hidden" name="typeGet" value="updateUser">
                            <input type="hidden" name="id" value="${user.id}">
                            <button class="btn btn-primary" type="submit">Update</button>
                        </form>
                    </td>
                    <td>
                        <form action="user-servlet" method="get">
                            <input type="hidden" name="typeGet" value="deleteUser">
                            <input type="hidden" name="id" value="${user.id}">
                            <button class="btn btn-primary" type="submit">Delete</button>
                        </form>
                    </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
