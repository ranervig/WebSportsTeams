import java.time.LocalDate;
import java.util.List;

import controller.GameHelper;
import model.Game;
import model.SportsTeam;

public class GameTester {

	public static void main(String[] args) {

		SportsTeam vikings = new SportsTeam("Vikings", "Minnesota", 52);
		
		GameHelper gh = new GameHelper();
		
		Game game1 = new Game("Minneapolis", LocalDate.now(), vikings);
		
		gh.insertNewGame(game1);
		List<Game> allGames = gh.getGames();
		
		for(Game g : allGames) {
			System.out.println(g.toString());
		}
	}
}
