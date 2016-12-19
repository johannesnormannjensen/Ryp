<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<span class="lead">Review about ${review.target_user_id} </span>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Title</th>
				<th>Body</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${review.title}</td>
				<td>${review.body}</td>
			</tr>

		</tbody>
	</table>
</div>
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<span class="lead">Comments </span>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>From</th>
				<th>Content</th>
				<th>At</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${commentForms}" var="comment">
				<tr>
					<td>${comment.username}</td>
					<td>${comment.body}</td>
					<td>${comment.created_at}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="generic-container">
    <div class="panel panel-default">
     		
                <form:form  method="POST" modelAttribute="commentForm" class="form-horizontal">
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="body"><i class="fa fa-lock"></i></label>
                        <form:input type="text" class="form-control" id="body" name="body" path="body" placeholder="Comment"  />
                        <form:input type="text" class="form-control" id="body" name="body" path="body" placeholder="Enter your comment here..."  />
                    </div>					
                  	
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />   
					    
					
					 <div class="form-actions">
					<input type="submit" value="Add comment" class="btn btn-block btn-success btn-default"/>
                </div>             
                </form:form>
        </div>
    </div>