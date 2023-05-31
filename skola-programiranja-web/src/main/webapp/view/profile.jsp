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
	<h1>WELCOME TO PROFILE</h1>
	
	<a href = "logout.jsp"><img src="../slike/logout.jfif"/></a> <br>

	<p>Dobrodosao chief ${user.userName}</p>
	

</body>
</html>