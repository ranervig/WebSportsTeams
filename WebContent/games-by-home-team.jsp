<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Games</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>All Games</header>
	<nav>
		<a href="index.html">Add a Team</a> <a href="addGameServlet">Add a
			Game</a> <a href="viewAllTeamsServlet">View the team list</a> <a
			href="viewAllHomeGamesServlet">View all the Games</a>
	</nav>
	<div class="main">
		<form method="post" action="gameNavServlet">
			<table>
				<c:forEach items="${requestScope.allTeams}" var="currentTeam">
					<tr>
						<td colspan="5">${currentTeam.city} ${currentTeam.teamName}</td>
					</tr>
					<c:forEach items="${requestScope.allGames}" var="currentGame">
						<c:if test="${currentGame.homeTeam.id == currentTeam.id}">
							<tr>
								<td>
									<div class="card">
										<p>
											<input type="radio" name="id" value="${currentGame.id}">
											Date: ${currentGame.gameDate}<br>
											Location:${currentGame.location}<br> Away Team:
											${currentGame.awayTeam.city} ${currentGame.awayTeam.teamName}<br>
											Score: ${currentGame.homeScore} - ${currentGame.awayScore}<br>
										</p>

										<c:if test="${currentGame.awayScore < currentGame.homeScore}">
											<p class="win">W</p>
										</c:if>
										<c:if test="${currentGame.awayScore > currentGame.homeScore}">
											<p class="lose">L</p>
										</c:if>
										<c:if test="${currentGame.awayScore == currentGame.homeScore}">
											<p class="tie">T</p>
										</c:if>
									</div>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</table>
			<div class="error">
				<c:out value="${requestScope.error_message}" default="" />
			</div>
			<input type="submit" value="add" name="doThisToGame"> 
			<input type="submit" value="delete" name="doThisToGame">
		</form>
	</div>
</body>
</html>