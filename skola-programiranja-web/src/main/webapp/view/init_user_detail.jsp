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
	
	<a href = "view/users.jsp">back to previous page</a>
	
	<p>User id: ${idUser}</p>
	
	<p>TIMOVI</p>
	<c:forEach var = "tim" items="${listaTimova}">	
		<p> ${tim.nazivTima}</p>
	</c:forEach>
	
	<p>POZICIJE</p>
	<c:forEach var = "pozicija" items="${listaPozicija}">	
		<p> ${pozicija.nazivPozicije}</p>
	</c:forEach>


</body>
</html>