<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>Dobro dosli na stranicu<p>
<a href="<spring:url value="/registracija"/>">Registrujte se</a><br>
<a href="<spring:url value="/prijava"/>">Prijavite se</a>
</body>
</html>
