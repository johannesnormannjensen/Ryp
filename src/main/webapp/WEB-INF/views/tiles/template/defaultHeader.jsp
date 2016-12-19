<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/"/>">Rate Your Peers</a>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		
		<div class="navbar-header">
			<a class="navbar-brand" style="padding-left: 100px;">Welcome back
				${remoteUser.username}</a>
		</div>
		</div>
	<div class="container">
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
			
				<li><spring:message code="header.rating.on"/> <spring:message code='riot.api.region'/></li>
			</ul>
		</div>
	</div>
</nav>
