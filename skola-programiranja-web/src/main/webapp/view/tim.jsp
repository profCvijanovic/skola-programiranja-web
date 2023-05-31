<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.TimDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tim</title>
		<link
			type="text/css"
			rel = "stylesheet"
			href="css/style.css"
		/>
</head>
<body>
	
	<jsp:useBean id = "listaTimova" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<h1>WELCOME TO TIM PAGE</h1>
	
	<a href = "view/chief.jsp">back to CHIEF page</a>
	
	<table border = "1">
		<tr>
			<th>NAZIV</th>
			<th>OPIS</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		
		<c:forEach var = "tim" items="${listaTimova}">
		
			<tr> 
				<td> ${tim.nazivTima} </td>
				<td> ${tim.opis}</td>
			</tr>
		
		</c:forEach>
	
	
	</table>
	
	<form action="#" method="get">	
		<input type="submit" value="ADD TEAM">
	</form>

	


</body>
</html>