<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>

<body>
	<h2>Show Profiles</h2>
	<table>
		<c:forEach var="profile" items="${profileList}" >
			<tr>
				<td><a href="profiles/${profile.userId}"><c:out value="${profile.name}" /></a></td>
				<td><c:out value="${profile.placeOfBirth}" /></td>
				<td><c:out value="${profile.gender}" /></td>
				<td><c:out value="${profile.work}" /></td>
				<td><c:out value="${profile.university}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>

