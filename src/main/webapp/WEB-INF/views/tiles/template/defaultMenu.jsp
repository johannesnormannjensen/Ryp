<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<ul class="list-group">
	<li class="list-group-item"><a href="<c:url value="/"/>">Home</a></li>
	<li class="list-group-item"><a href="<c:url value="/reviews"/>">Reviews</a></li>
	<li class="list-group-item"><a href="<c:url value="/matchhistory"/>">Match History</a></li>
	<li class="list-group-item"><a href="<c:url value="/friend/list"/>">Friends</a></li>
	<sec:authorize access="hasRole('ADMIN')">
		<li class="list-group-item"><a href="<c:url value="/newuser"/>">Register new User</a></li>
	</sec:authorize>
</ul>
