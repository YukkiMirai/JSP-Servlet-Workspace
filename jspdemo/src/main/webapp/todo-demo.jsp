<%@page import="java.util.*"%>
<html>

<body>

	<!-- step 1: Create HTML form -->
	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="theItem" /> <input
			type="submit" value="Submit" />
	</form>

	<!-- step 2: Add new item to "To Do" list -->

	<%
	//get the TO DO items from the session
	// (List<String>) downcasting
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	/**
	deu duoc
		//ArrayList<String> items = (ArrayList<String>) session.getAttribute("myToDoList");
	*/

	//if the TO DO items doesn't exist, the create a new one

	if (items == null) {
		items = new ArrayList<String>();
		
		session.setAttribute("myToDoList", items);
	}
	//see if there is form data to addh
	String theItem = request.getParameter("teItem");

	Boolean theItemNotEmpty = theItem != null && theItem.trim().length() > 0;
	Boolean theItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
	if (theItemNotEmpty && theItemNotDuplicate) {
		items.add(theItem.trim());
	}
	
	%>

	<!-- step 3: Display all "To Do item from session -->
	<hr>
	<b>To List Items</b>

	<ol>
		<%
		for (String temp : items) {
			out.println("<li>" + temp + "</li>");
		}
		%>
	</ol>
	<br/><br/>
	Session ID is: ${pageContext.session.id}
	<%
		out.println("<br/>" + session.getId());
	%>
	
	
</body>

</html>