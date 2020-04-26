<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.rubber.band.facebookX.model.ProfileDB"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>

<body>
	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${profile.name}</td>
		</tr>
		<tr>
			<td>Date of Birth</td>
			<td>${profile.dateOfBirth}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${profile.gender}</td>
		</tr>
		<tr>
			<td>Work</td>
			<td>${profile.work}</td>
		</tr>
		<tr>
			<td>University</td>
			<td>${profile.university}</td>
		</tr>
	</table>
	<%
		/*java.util.Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			out.print(s);
			out.println("==" + request.getAttribute(s));}*/
		Object prof = request.getAttribute("profile");
		if (prof == null)
			System.out.println("Object is NULL");
		else
			System.out.println("Object is NOT NULL");

		ProfileDB profile = (ProfileDB) prof;
		if (profile == null)
			System.out.println("Profile Is NULL");
		else
			System.out.println("Profile is NOT NULL");
		System.out.println(session.getAttribute("userId") + " " + profile.getUserId());
		if (session.getAttribute("userId").equals(profile.getUserId())) {
	%>
	<form:form method="get" action="posts">
		<input type="submit" value="Post Page" />
	</form:form>
	<form:form method="get" action="profiles">
		<input type="submit" value="Profiles List" />
	</form:form>
	<%
		}
	%>
</body>

</html>
