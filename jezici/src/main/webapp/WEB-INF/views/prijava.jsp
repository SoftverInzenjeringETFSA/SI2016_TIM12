<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Registracija</title>
</head>
<body>
	<form action="<spring:url value="/prijava/"/>" method="post">
  Korisnicko ime:<br>
  <input type="text" name="korisnickoIme" required>
     <br>
  Sifra:<br>
  <input type="password" name="sifra" required>
  <br><br>
  <input type="submit" value="Submit">
</form> 

</body>