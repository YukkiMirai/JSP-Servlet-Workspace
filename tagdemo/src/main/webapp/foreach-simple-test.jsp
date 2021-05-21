<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//just create some sample data ... normally provided by MVC
	String[] cities = {"Yukki","Bakie","Love"};
	pageContext.setAttribute("myCities", cities);
%>
<body>
	<c:forEach var ="tempCity" items="${myCities }">
		${tempCity }<br/>
	</c:forEach>

</body>