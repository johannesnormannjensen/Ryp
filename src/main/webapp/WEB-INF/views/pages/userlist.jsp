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
            	<sec:authorize access="hasRole('ADMIN')">
                	<th>Email</th>
                </sec:authorize>
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
            	<sec:authorize access="hasRole('ADMIN')">
	            	<c:choose>
	            		<c:when test="${user.active}">
			                <tr class="success">
	            		</c:when>
	            		<c:otherwise>
	            			<tr class="danger">
	            		</c:otherwise>
	            	</c:choose>
	                    <td>${user.email}</td>
	                    <td>${user.username}</td>
	                    <td><a href="<c:url value='/user/friend/sendFriendshipRequest${user.id}' />" class="btn btn-warning custom-width">Add</a></td>
                        <td><a href="<c:url value='/admin/edit-user-${user.username}' />" class="btn btn-success custom-width">edit</a></td>
                        <td><a href="<c:url value='/admin/delete-user-${user.username}' />" class="btn btn-danger custom-width">delete</a></td>
	                    <c:choose>
		            		<c:when test="${user.active}">
	                        	<td><a href="<c:url value='/admin/user-activation-${user.username}' />" class="btn btn-danger custom-width">Deactivate</a></td>
		            		</c:when>
		            		<c:otherwise>
		            			<td><a href="<c:url value='/admin/user-activation-${user.username}' />" class="btn btn-success custom-width">Activate</a></td>
		            		</c:otherwise>
		            	</c:choose>
	                </tr>
            	</sec:authorize>
            	<sec:authorize access="hasRole('USER')">
	            	<tr>
	                    <td>${user.username}</td>
	                    <td><a href="<c:url value='/user/friend/sendFriendshipRequest${user.id}' />" class="btn btn-info custom-width">Add friend</a></td>
	                </tr>
            	</sec:authorize>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary pull-right" style="margin-top:5px;" href="<c:url value="/admin/newUser"/>">Register new User</a>
    </div>
</div>
