<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>chief</title>
		<link
			type="text/css"
			rel = "stylesheet"
			href="../css/style.css"
		/>
</head>
<body>
	
	<jsp:useBean id = "user" scope="session" class="model.User"></jsp:useBean>
	<h1>WELCOME TO CHIEF PAGE</h1>
	
	<a href = "logout.jsp"><img src="../slike/logout.jfif"/></a> <br>

	<p>Dobrodosao chief ${user.userName}</p>
	
	<p>CHIEF ima opciju da uradi sledece:</p>
	<ol type="a">
		<li> Vidi i edituje svoj profil</li>
		<li> Dodaje i uredjuje timove </li>
		<li> Dodaje i uredjuje pozicije </li>
		<li> Dodaje i uredjuje role </li>
		<li> Dodaje i uredjuje user details (i adresu i kontakte) </li>
		<li> Dodaje i uredjuje zaposlene i njihove pozicije </li>
		<li> Dodaje i uredjuje projekte </li>
	</ol>
	
	<table border="1">
		<tr>
			<th>REDNI BROJ</th>
			<th>NAZIV AKCIJE</th>
			<th>DUGME</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Profil</td>
			<td>
				<form action="../ProfilController" method="get">
					<input type="hidden" name="idUser" value="${user.id}">
					<input type="submit" value="PROFIL">
				</form>
			</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Timovi</td>
			<td>
				<form action="../TimController" method="get">
					<input type="submit" value="TIMOVI">
				</form>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Pozicije</td>
			<td>pozicije dugme</td>
		</tr>
		<tr>
			<td>4</td>
			<td>Role</td>
			<td>role dugme</td>
		</tr>
		<tr>
			<td>5</td>
			<td>User details</td>
			<td>details dugme</td>
		</tr>
		<tr>
			<td>6</td>
			<td>Zaposleni</td>
			<td>zaposleni dugme</td>
		</tr>
		<tr>
			<td>7</td>
			<td>Projekti</td>
			<td>projekti dugme</td>
		</tr>
	
	</table>

</body>
</html>