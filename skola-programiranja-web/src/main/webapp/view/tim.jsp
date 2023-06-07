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
				<td>				
						<form action="EditTimController" method="get">	
							Novi Naziv tima: <input type="text" name="nazivTima">
							Novi Opis: <input type="text" name="opis">
								  <input type="hidden" name="idTim" value="${tim.id}">
							      <input type="submit" value="edit">
						</form>
				</td>
				
				<td>
					<c:url var = "delete" value="DeleteTimController">
						<c:param name="idTim" value="${tim.id}"/>
					</c:url>
					<a href = "${delete}"><button>delete</button></a>
				</td>
			</tr>
		
		</c:forEach>
	
	
	</table>
	
	<br><br>
	
	<form action="AddTimController" method="get">	
		Naziv tima: <input type="text" name="nazivTima">
		Opis: <input type="text" name="opis">
		<input type="submit" value="ADD TEAM">
	</form>

	


</body>
</html>