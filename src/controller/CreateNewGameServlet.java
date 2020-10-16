package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.SportsTeam;

/**
 * Servlet implementation class CreateNewGameServlet
 */
@WebServlet("/createNewGameServlet")
public class CreateNewGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewGameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GameHelper gh = new GameHelper();
		String location = request.getParameter("location");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String homeScore = request.getParameter("homeScore");
		String awayScore = request.getParameter("awayScore");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		int hScore;
		int aScore;
		try {
			hScore = Integer.parseInt(homeScore);
		} catch (NumberFormatException e) {
			hScore = 0;
		}
		try {
			aScore = Integer.parseInt(awayScore);
		} catch (NumberFormatException e) {
			aScore = 0;
		}

		String homeTeam = request.getParameter("homeTeam");
		String awayTeam = request.getParameter("awayTeam");
		SportsTeamHelper sth = new SportsTeamHelper();
		SportsTeam home = sth.searchforTeamById(Integer.parseInt(homeTeam));
		SportsTeam away = sth.searchforTeamById(Integer.parseInt(awayTeam));

		Game gta = new Game(location, ld, hScore, aScore, home, away);
		
		gh.insertNewGame(gta);
		
		getServletContext().getRequestDispatcher("/viewAllHomeGamesServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
