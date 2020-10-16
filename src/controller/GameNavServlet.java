package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameNavServlet
 */
@WebServlet("/gameNavServlet")
public class GameNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameHelper gh = new GameHelper();
		String act = request.getParameter("doThisToGame");
		
		String path = "/viewAllHomeGamesServlet";
		
		if(act.equals("delete")) {
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				gh.deleteGame(tempId);
			}catch(NumberFormatException e) {
				//returns an error message to be displayed
				request.setAttribute("error_message", "Forgot to select a game");
			}
		}else if(act.equals("add")){
			path = "/addGameServlet";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
