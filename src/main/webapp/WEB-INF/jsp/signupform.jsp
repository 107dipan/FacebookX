<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<title>Reservation Form</title>
</head>
<h3>FacebookX SignUp Form</h3>
<body>
	<form:form method="post" action="signupsubmit" modelAttribute="wrap">
		<table>
			<tr>
				<td>emailId :</td>
				<td><form:input path="auth.emailId" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="auth.password" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="prof.name" /></td>
			</tr>
			<tr>
				<td>Place of Birth :</td>
				<td><form:input path="prof.placeOfBirth" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input path="prof.gender" /></td>
			</tr>
			<tr>
				<td>Work :</td>
				<td><form:input path="prof.work" /></td>
			</tr>
			<tr>
				<td>University :</td>
				<td><form:input path="prof.university" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>