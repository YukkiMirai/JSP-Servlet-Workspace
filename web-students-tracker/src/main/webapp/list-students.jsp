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
			<!-- put new button: Add Student -->
			<input type="button" value="Add Student"
				onclick="window.location.href='add-student-form.jsp'; return false;"
				class="add-student-button"
			/>
			
			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
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
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="studentId" value="${tempStudent.id }"></c:param>			
					</c:url>
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE"></c:param>
						<c:param name="studentId" value="${tempStudent.id }"></c:param>
					</c:url>
					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName }</td>
						<td>${tempStudent.email }</td>
						
						<td> <a href="${tempLink }">Update</a>|<a href="${deleteLink }" onclick="if(!(confirm('Are you sure'))) return false">Delete</a> </td>						
					</tr>				
				</c:forEach>

			</table>

		</div>

	</div>
</body>


</html>








