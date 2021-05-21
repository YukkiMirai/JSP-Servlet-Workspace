<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<body>
	<c:set var="data" value="Singapore,Toyko,Mumbai,London" />
	<h3>Split demo - Splits a string into an array of substrings.</h3>
	<c:set var="citiesArray" value="${fn:split(data, ',') }" />
	<c:forEach var="tempCity" items="${citiesArray}">
	${tempCity} <br />
	</c:forEach>
	<h3>Join Demo - Joins all elements of an array into a string.</h3>
	<!-- Split tách chuỗi dài thành các chuỗi nhỏ  -->
	
	<c:set var="fun" value="${fn:join(citiesArray, '*') }"/>
	
	Result of joining: ${fun}
	<br />
	leng: ${fn:length(fun)}  
</body>
</html>
