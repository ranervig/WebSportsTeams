package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.SportsTeam;

/**
 * Servlet implementation class viewAllHomeGamesServlet
 */
@WebServlet("/viewAllHomeGamesServlet")
public class viewAllHomeGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllHomeGamesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsTeamHelper sth = new SportsTeamHelper();
		List<SportsTeam> at = sth.showAllTeams();
		request.setAttribute("allTeams", at);
		GameHelper gh = new GameHelper();
		List<Game> ag = gh.getGames();
		request.setAttribute("allGames", ag);
		
		String path = "/games-by-home-team.jsp";
		
		if(ag.isEmpty()) {
			path = "/new-game.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
