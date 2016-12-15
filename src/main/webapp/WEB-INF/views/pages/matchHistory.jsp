<%--
  Created by IntelliJ IDEA.
  User: Ferenc_S
  Date: 12/15/2016
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Friends </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>CreateDate</th>
                <th>Result</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${games}" var="game">
                <tr>
                    <td>${game.createDate}</td>
                    <td>${game.stats.win ? "Wonnered" : "Vayned Out"}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
