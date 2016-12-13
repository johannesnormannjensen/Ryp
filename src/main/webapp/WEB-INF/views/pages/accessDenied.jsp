<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AccessDenied page</title>
</head>
<body>
	<div class="generic-container">
		<div class="authbar">
			<span>Dear
				<strong>
					<c:choose>
					<c:when test="${not empty sessionScope.remoteUser}">
						${sessionScope.remoteUser.username}
					</c:when>
					<c:otherwise>
						Some guy
					</c:otherwise>
					</c:choose>
				</strong>, You are not authorized to access this page.
			</span>
		</div>
	</div>
</body>
</html>