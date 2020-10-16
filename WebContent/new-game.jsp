<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Game</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>New Game</header>
		<nav>
			<a href="index.html">Add a Team</a>
			<a href="addGameServlet">Add a Game</a>
			<a href="viewAllTeamsServlet">View the team list</a> 
			<a href="viewAllHomeGamesServlet">View all the Games</a>
		</nav>
	<div class="main">
		<form action="createNewGameServlet" method="post">
			Home Team:<select name="homeTeam">
				<c:forEach items="${requestScope.allTeams}" var="currentTeam">
					<option value="${currentTeam.id}">${currentTeam.city}
						${currentTeam.teamName}</option>
				</c:forEach>
			</select> Away Team:<select name="awayTeam">
				<c:forEach items="${requestScope.allTeams}" var="currentTeam">
					<option value="${currentTeam.id}">${currentTeam.city}
						${currentTeam.teamName}</option>
				</c:forEach>
			</select><br> Location: <input type="text" name="location"><br>
			Game Day: <input type="text" name="month" placeholder="mm" size="4"><input
				type="text" name="day" placeholder="dd" size="4">, <input
				type="text" name="year" placeholder="yyyy" size="4"><br>
			Score: H<input type="text" name="homeScore" size="3"> - A <input
				type="text" name="awayScore" size="3">
			<input type="submit" value="Create Game">
		</form>
	</div>

</body>
</html>