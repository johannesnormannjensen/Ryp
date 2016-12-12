<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<ul class="list-group">
	<li class="list-group-item"><a href="<c:url value="/"/>">Home</a></li>
	<li class="list-group-item"><a href="<c:url value="/reviews"/>">Reviews</a></li>
	<li class="list-group-item"><a href="<c:url value="/matchhistory"/>">Match History</a></li>
	<sec:authorize access="hasRole('ADMIN')">
		<li class="list-group-item"><a href="<c:url value="/registration"/>">Register new User</a></li>
	</sec:authorize>
</ul>
