<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="generic-container">
    <div class="panel panel-default">
     		
                <form:form  method="POST" modelAttribute="reviewForm" class="form-horizontal">
                   <div class="input-group input-sm">
                        <label class="input-group-addon" for="title"><i class="fa fa-user"></i></label>
                        <form:input type="text" class="form-control" id="title" name="title" path="title" placeholder="Title comes here" />
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="body"><i class="fa fa-lock"></i></label>
                        <form:input type="text" class="form-control" id="body" name="body" path="body" placeholder="Enter review here"  />
                    </div>					
                  	
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />   
					    
					<form:input  type="hidden" id="source_user_id" name="source_user_id" path="source_user_id" value="${reviewForm.source_user_id}" /> 
					<form:input  type="hidden" id="target_user_id" name="target_user_id" path="target_user_id" value="${reviewForm.target_user_id}" /> 
					<form:input  type="hidden" id="game_id" name="game_id" path="game_id" value="${reviewForm.game_id}"/> 
					
					 <div class="form-actions">
					<input type="submit" value="Save Review" class="btn btn-block btn-success btn-default"/>
                </div>             
                </form:form>
                
                <div class="form-actions" >
					<a href="<c:url value="/user/reviews/list"/>" class="btn btn-block btn-Danger btn-default" >Cancel</a>
                </div>
        </div>
    </div>
