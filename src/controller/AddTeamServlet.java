package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;

/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("teamName");
		String city = request.getParameter("city");
		Integer players = Integer.parseInt(request.getParameter("players"));
		
		SportsTeam team = new SportsTeam(name, city, players);
		SportsTeamHelper sth = new SportsTeamHelper();
		sth.insertTeam(team);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
