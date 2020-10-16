<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Teams</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
	All Teams
</header>
	<nav>
		<a href="index.html">Add a Team</a>
		<a href="addGameServlet">Add a Game</a>
		<a href="viewAllTeamsServlet">View the team list</a> 
		<a href="viewAllHomeGamesServlet">View all the Games</a>
	</nav>
<div class="main">
	<form method="post" action="navServlet">
		<table>
			<tr>
				<th></th>
				<th>Team Name</th>
				<th>City</th>
				<th>Players</th>
			</tr>
			<c:forEach items="${requestScope.allTeams}" var="currentTeam">
				<tr>
					<td><input type="radio" name="id" value="${currentTeam.id}"></td>
					<td>${currentTeam.teamName}</td>
					<td>${currentTeam.city}</td>
					<td>${currentTeam.playerCount}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="error">
		<c:out value="${requestScope.error_message}" default=""/>
		</div>
		<p>
			<input type="submit" value="edit" name="doThisToTeam">
			<input type="submit" value="add" name="doThisToTeam">
		</p>
	</form>
</div>
</body>
</html>