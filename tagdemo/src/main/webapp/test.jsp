<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:set var="stuff" value="<%= new java.util.Date() %>"/>

Time con the server is ${stuff }
</body>
</html>
