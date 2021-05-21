<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="theLocale"
value="${not empty param.theLocale ? param.theLocale: pageContext.request.locale }"
scope="session"/>
<fmt:setLocale value="${theLocale }"/>

<fmt:setBundle basename="com.luv2code.jsp.tagdemo.i18n.resources.mylabels"/>

<html>

<body>
${theLocale }
<a href="i18n-messages-test.jsp?theLocale=en_US">Englinh (US)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE">Spanish (DE)</a>

<hr>

<fmt:message key ="label.greating"/> <br/><br/>
<fmt:message key ="label.firstname"/> John <br/><br/>
<fmt:message key ="label.lastname"/> Doe <br/><br/>
<fmt:message key ="label.welcome"/> <br/><br/>


</body>

</html>