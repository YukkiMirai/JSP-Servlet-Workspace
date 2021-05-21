<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hello world of Java</h3>

<%
	for(int i=1;i<5;i++){
		out.println("<br/> I really luv2code: " +i);
	}
	out.print("<br/>I love Bakie");
%>
</body>
</html>