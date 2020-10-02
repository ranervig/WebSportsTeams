package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportsTeam;


/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportsTeamHelper sth = new SportsTeamHelper();
		String act = request.getParameter("doThisToTeam");

		String path = "/viewAllTeamsServlet";
		
		if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			sth.deleteTeam(tempId);
			}catch(NumberFormatException e) {
				//returns an error message to be displayed
				request.setAttribute("error_message", "Forgot to select a team");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SportsTeam teamToEdit = sth.searchforTeamById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				path = "/edit-team.jsp";
			}catch(NumberFormatException e) {
				//returns an error message to be displayed
				request.setAttribute("error_message", "Forgot to select a team");
			}
		
		}else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
