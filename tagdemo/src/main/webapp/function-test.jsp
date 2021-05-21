   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="java.util.*"%>

<html>

<body>

<c:set var="data" value ="luv2code"/>
Length of the String <b>${data }</b>:${fn:length(data) }
<br></br>
Uppercase version of the string <b>${data }</b>: ${fn:toUpperCase(data) }
<br></br>
Does the string <b>${data }</b> start with <b>luv</b>?: ${fn:startsWith(data,"luv") }
<br></br>
Sub string <b>${data }</b>: ${fn:substringAfter(data,"2") }


</body>
</html>