<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="generic-container">
	<c:if test="${param.createdUser != null}">
	    <div class="alert alert-success">
	        <p>${request.getParameter("createdUser")}</p>
	    </div>
	</c:if>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Email</th>
                <th>Username</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                     <sec:authorize access="hasRole('ADMIN')">
                        <td><a href="<c:url value='/user/friend/sendFriendshipRequest${user.id}' />" class="btn btn-warning custom-width">Add</a></td>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                        <td><a href="<c:url value='/admin/edit-user-${user.username}' />" class="btn btn-success custom-width">edit</a></td>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <td><a href="<c:url value='/admin/delete-user-${user.username}' />" class="btn btn-danger custom-width">delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary pull-right" style="margin-top:5px;" href="<c:url value="/admin/newUser"/>">Register new User</a>
    </div>
</div>
