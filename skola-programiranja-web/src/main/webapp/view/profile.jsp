<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.ProfilDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>chief</title>
		<link
			type="text/css"
			rel = "stylesheet"
			href="css/style.css"
		/>
</head>
<body>
	
	<jsp:useBean id = "profil" scope="request" class="dto.ProfilDto"></jsp:useBean>
	<h1>WELCOME TO PROFILE</h1>
	

	<p>Dobrodosao ${profil.userName}</p>
	
	<a href = "view/chief.jsp">back to previous page</a>
	
	<table border="1">
		<tr> <th>PROFILNI PODACI</th> </tr>
		<tr>
			<td> USERNAME </td>
			<td> ${profil.userName} </td>
		</tr>
		<tr>
			<td> SIFRA ZAPOSLENOG </td>
			<td> ${profil.sifraZaposlenog} </td>
		</tr>
		<tr>
			<td> IME </td>
			<td> ${profil.ime} </td>
		</tr>
		<tr>
			<td> PREZIME </td>
			<td> ${profil.prezime} </td>
		</tr>

	</table>
	
	<table border="1">
		<tr><th>ADRESA</th></tr>
		<tr>
			<td> DRZAVA </td>
			<td> ${profil.drzava} </td>
		</tr>
		<tr>
			<td> GRAD </td>
			<td> ${profil.grad} </td>
		</tr>
		<tr>
			<td> ULICA </td>
			<td> ${profil.ulica} </td>
		</tr>
		<tr>
			<td> POSTANSKI BROJ </td>
			<td> ${profil.postanskiBroj} </td>
		</tr>
	
	</table>
	
	<table border="1">
		<tr><th>TIM</th></tr>
		<tr><td>${profil.nazivTima}</td></tr>
	</table>
	

</body>
</html>