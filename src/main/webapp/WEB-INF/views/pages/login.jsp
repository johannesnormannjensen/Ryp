
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="mainWrapper">
    <div class="login-container">
        <div class="login-card">
            <div class="login-form">
                <c:url var="loginUrl" value="/login" />
                <form action="${loginUrl}" method="post" class="form-horizontal">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password. Maybe region?</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <c:if test="${success != null}">
	                    <div class="alert alert-success lead">
					        ${success}
					    </div>
                    </c:if>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                        <input type="text" class="form-control" id="username" name="username" value="saitama" placeholder="Enter Username" required>
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                        <input type="password" class="form-control" id="password" name="password" value="saitama" placeholder="Enter Password" required>
                    </div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i class="fa fa-group"></i></label>
						<input type="text" class="form-control" id="region" name="region" placeholder="Select region" required>
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								Action <span class="caret"></span>
							</button>
							<ul class="dropdown-menu dropdown-menu-right" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</div>
					<div class="input-group input-sm">
						<div class="checkbox">
							<label><input type="checkbox" id="rememberme"
								name="remember-me"> Remember Me</label>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                    <div class="form-actions">
                        <input type="submit"
                               class="btn btn-block btn-primary btn-default" value="Log in">
                    </div>
                </form>
                <div class="form-actions">
					<a href="<c:url value="/registration"/>" class="btn btn-block btn-success btn-default" >Register</a>
                </div>
        </div>
    </div>
</div>
