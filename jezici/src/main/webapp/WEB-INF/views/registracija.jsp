<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Registracija</title>
</head>
<body>
	<form action="<spring:url value="/registracija/"/>" method="post" name="noviStudent">
  Ime:<br>
  <input type="text" name="ime" required>
  <br>
  Prezime:<br>
  <input type="text" name="prezime" required>
   <br>
  Mjesto rodjenja:<br>
  <input type="text" name="mjestoRodjenja" required>
   <br>
  Datume rodjenja:<br>
  <input type="date" name="datumRodjenja" required>
   <br>
  JBMG:<br>
  <input type="text" name="jmbg" required>
   <br>
  Korisnicko ime:<br>
  <input type="text" name="korisnickoIme" required>
   <br>
  Adresa boravista:<br>
  <input type="text" name="adresaBoravista" required>
     <br>
  Sifra:<br>
  <input type="password" name="sifra" required>
   <br>
  Email:<br>
  <input type="text" name="email" required>
  <br><br>
  <input type="submit" value="Submit">
</form> 

</body>