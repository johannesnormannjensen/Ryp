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
            <c:forEach items="${matches}" var="match">
                <tr data-toggle="collapse" data-target="#accordion${match.id}" class="clickable">
                    <td><fmt:formatDate value="${match.created_at}" pattern="dd/MM/yyyy HH:mm"/></td>
                    <td>${match.didPlayerWin(playerId) ? "Wonnered" : "Vayned Out"}</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <div id="accordion${match.id}" class="collapse">
                            <c:forEach items="${match.playerInfos}" var="playerInfo">

                                <div class="alert alert-${playerInfo.teamId == 100 ? "success":"danger"}">
                                    <p>
                                        <a href="/user/reviews/createReview?target_user_id=${playerInfo.summonerId}&game_id=${match.id}">${playerInfo.summonerName}
                                        </a></p></div>
                            </c:forEach>
                        </div>
                    </td>
                </tr>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
