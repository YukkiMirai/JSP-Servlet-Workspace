<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.luv2code.jsp.tagdemo.*"%>
<%@ page import="java.util.*"%>


<%
List<Student> students = new ArrayList<Student>();
students.add(new Student("Yukki", "Asuna", true));
students.add(new Student("Blo", "Kirito", true));
students.add(new Student("Bakie", "Katana", false));
pageContext.setAttribute("myStudents", students);
%>
<html>
<body>
	<table border="1">
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Gold Custommer</th>
		</tr>
		<c:forEach var="tempStudent" items="${myStudents}">

			<tr>
				<td>${tempStudent.firstName }</td>
				<td>${tempStudent.lastName }</td>
				<td><c:choose>
						<c:when test="${tempStudent.goldCustomer}">
							Special Discount
						</c:when>
						<c:otherwise>
							no soup for you!
						</c:otherwise>
					</c:choose></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>