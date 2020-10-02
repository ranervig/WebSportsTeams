package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;

/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportsTeamHelper sth = new SportsTeamHelper();
		
		String teamName = request.getParameter("teamName");
		String city = request.getParameter("city");
		Integer players = Integer.parseInt(request.getParameter("playerCount"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		SportsTeam teamToUpdate = sth.searchforTeamById(tempId);
		teamToUpdate.setTeamName(teamName);
		teamToUpdate.setCity(city);
		teamToUpdate.setPlayerCount(players);
		
		sth.updateTeam(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
