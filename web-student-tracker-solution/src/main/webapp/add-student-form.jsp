<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/add-student-style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<form action="StudentControllerServletYukki" method="get">
	
		<input type="hidden" value="ADD" name="command" /> 
			First Name:
			<input
			type="text" name="firstName" /> </br></br>
			Last Name:
			<input type="text"
			name="lastName" /> </br></br>
			Email: 
			<input type="text" name="email" /></br></br>
			
			<input type="submit" value="Submit" class="save"/>
	</form>
</body>
</html>