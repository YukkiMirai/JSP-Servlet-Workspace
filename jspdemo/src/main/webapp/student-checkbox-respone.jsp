<html>

<head><title>Student Confirmation Title</title></head>

<body>
	
	The student is confirmed: ${param.firstName} ${param.lastName }
	<br /> <br /> 
	
	The student's favorite programing language: 
	<ul>
		<%
			String[] langs = request.getParameterValues("favoriteLanguage"); 
			try{
				for(String lang: langs){
					out.print("<li>"+lang+"</li>");
				}
			}catch(NullPointerException e){
				out.print("<li>"+"deo co dau nhe"+"</li>");
			}
		%>
	</ul>	
	
	<!--//ghi chu: The student is confirmed: <%= request.getParameter("firstName") %>
	<%= request.getParameter("lastName") %> --> 
	 
</body>
</html>