<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Student Tracker App</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<%-- <%
// get the students from the request object (sent by servlet)
List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>
thay cai tren = jstl --%>
<c:set var="theStudents" value="${STUDENT_LIST }" />

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<%-- <% for (Student tempStudent : theStudents) { %>
				
					<tr>
						<td> <%= tempStudent.getFirstName() %> </td>
						<td> <%= tempStudent.getLastName() %> </td>
						<td> <%= tempStudent.getEmail() %> </td>
					</tr>
					<% //ben duoi su dung jstl thay cho doan scriplet nay %>
				<% } %> --%>
				
				<c:forEach var="tempStudent" items="${STUDENT_LIST}"> 
					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName }</td>
						<td>${tempStudent.email }</td>
					</tr>				
				</c:forEach>

			</table>

		</div>

	</div>
</body>


</html>








