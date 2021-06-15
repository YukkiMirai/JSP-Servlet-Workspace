<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<c:set var="STUDENTS" value="${LIST_STUDENTS }"></c:set>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name:</th>
			<th>Last Name:</th>
			<th>Email:</th>
		</tr>
		<c:forEach var="tempStudent" items="${STUDENTS }">
			<tr>
				<td>${tempStudent.id }</td>
				<td>${tempStudent.firstName }</td>
				<td>${tempStudent.lastName }</td>
				<td>${tempStudent.email }</td>
			</tr>
		</c:forEach>


	</table>
	<input type="button" value="Add Student"
		onclick="window.location.href='add-student-form.jsp'; return false;"
		class="add-student-button" />

</body>
</html>