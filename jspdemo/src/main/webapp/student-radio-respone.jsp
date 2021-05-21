<html>

<head><title>Student Confirmation Title</title></head>

<body>
	
	The student is confirmed: ${param.firstName} ${param.lastName }
	<br /> <br /> 
	
	The student's favorite programing language: ${param.favoriteLanguage }
	
	<!--//ghi chu: The student is confirmed: <%= request.getParameter("firstName") %>
	<%= request.getParameter("lastName") %> --> 
	 
</body>
</html>