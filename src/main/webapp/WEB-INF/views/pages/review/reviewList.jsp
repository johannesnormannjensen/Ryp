<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">SUPPOSED TO BE REVIEWS </span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Title</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reviews}" var="review">
            <tr>
                <td>${review.title}</td>
                <sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
               		<td><a href="<c:url value='/user/reviews/review${review.id}' />" class="btn btn-success">See Details</a></td>
                    <td><a href="<c:url value='/user/reviews/deleteReview${review.id}' />" class="btn btn-danger">Delete Review</a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
