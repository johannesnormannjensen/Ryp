<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<ul class="list-group">
	<li class="list-group-item"><a href="<c:url value="/"/>">Reviews</a></li>
	<li class="list-group-item"><a href="<c:url value="/user/matchhistory"/>">Match History</a></li>
	<li class="list-group-item"><a href="<c:url value="/user/friend/list"/>">Friends</a></li>
	<sec:authorize access="hasRole('ADMIN')">
		<li class="list-group-item"><a href="<c:url value="/admin/list"/>">Users</a></li>
	</sec:authorize>
	<li class="list-group-item"><a href="<c:url value="/logout"/>">Log out</a></li>
</ul>
