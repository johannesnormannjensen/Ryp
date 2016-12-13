<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
 
<html>
 
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Rate Your Peers - <tiles:getAsString name="title" /></title>
	    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	    <link rel="shortcut icon" href="<c:url value='/static/favicon.ico' />"/>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>
	  
	<body>
	<c:choose>
		<c:when test="${not empty sessionScope.remoteUser}">
	        <tiles:insertAttribute name="header" />
	     	<div class="container-fluid">
				<div class="col-sm-2">
				    <tiles:insertAttribute name="menu" />
				</div>
				     
				<div class="col-sm-10">
				    <tiles:insertAttribute name="body" />
				</div>
	     	</div>
	        <tiles:insertAttribute name="footer" />
		</c:when>
		<c:otherwise>
		    <tiles:insertAttribute name="body" />
		</c:otherwise>
	</c:choose>
	</body>
</html>