<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

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
	
	<jsp:useBean id = "listaUsera" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<h1>WELCOME TO USERS PAGE</h1>
	
	<a href = "view/chief.jsp">back to previous page</a>
	
	<p>PODACI O USERIMA </p>
	<table border="1">
		<tr> <th>
				ID
			 </th> 
			 <th>
				USERNAME
			 </th> 
			 <th>
				PASSWORD
			 </th>
			 <th>
				ROLA
			 </th> 
			 <th>
				EDIT
			 </th>  
		</tr>
		<c:forEach var = "users" items="${listaUsera}">	
			<tr>
				<td>
				   ${users.id}
				</td>
				<td>
				   ${users.userName}
				</td>
				<td>
				   ${users.password}
				</td>
				<td>
				   ${users.rola}
				</td>
				<td>
					<c:url var = "initUsersDetails" value="InitUserDetailsController">
						<c:param name="idUser" value="${users.id}"/>
					</c:url>
					<a href = "${initUsersDetails}"><button>edit user</button></a>
				</td>
			</tr>
		</c:forEach>
		
		


	</table>
	



</body>
</html>