<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>Edit Team</header>
	<div class="main">
		<form action="editTeamServlet" method="post">
			Name: <input type="text" name="teamName" value="${teamToEdit.teamName}"> 
			City: <input type="text" name="city" value="${teamToEdit.city}"> 
			Players <input type="text" name="playerCount" value="${teamToEdit.playerCount}">
			<input type="hidden" name="id" value="${teamToEdit.id}">
			<input type="submit" value="Save Edited Team">
		</form>
	</div>
</body>
</html>