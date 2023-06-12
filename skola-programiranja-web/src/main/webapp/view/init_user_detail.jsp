<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.TimDto" %>
<%@ page import="dto.PozicijaDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.String" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all users</title>
		<link
			type="text/css"
			rel = "stylesheet"
			href="css/style.css"
		/>
</head>
<body>
	
	<jsp:useBean id = "listaTimova" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id = "listaPozicija" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id = "idUser" scope="request" class="java.lang.String"></jsp:useBean>
	<h1>WELCOME TO INIT USERS PAGE</h1>
	
	<a href = "UserController">back to previous page</a>
	
	<p>User id: ${idUser}</p>
	
	<form action="UserDetailsController" method="get">
		Drzava: <input type="text" name="drzava">
		Grad: <input type="text" name="grad">
		Ulica: <input type="text" name="ulica">
		Postanski broj: <input type="text" name="postanskiBroj">
		
		<br><br>
		Ime: <input type="text" name="ime">
		Prezime: <input type="text" name="prezime">
		
		<br><br>
		<input type="submit" value = "KREIRAJ USER DETAILS">
	
	</form>
	
	<form action="UserDetailsController" method="get">
		
		Plata: <input type="text" name="plata">
		Sifra zaposlenog: <input type="text" name="sifraZaposlenog">
		
		<br><br>
		Rola:  <br>
		CHIEF:<input type="radio" name="rola" value = "0">
		PROGRAMER:<input type="radio" name="rola" value = "1">
		
		<br><br>
		
		Tim:
		<select name="idTim">
		
			<c:forEach var = "tim" items="${listaTimova}">	
				<option value="${tim.id}">${tim.nazivTima}</option>
			</c:forEach>
		</select>
		
		<br><br>
		
		Pozicije:
		<c:forEach var = "pozicija" items="${listaPozicija}">	
			${pozicija.nazivPozicije} - <input type="checkbox" name="pozicija" value = "${pozicija.id}">
		</c:forEach>
		
		<input type="hidden" name="idUser" value = "${idUser}">
		
		<br><br>
		<input type="submit" value = "KREIRAJ ZAPOSLENOG I DODAJ ROLU">
	
	</form>
	

	



</body>
</html>