import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.SportsTeamHelper;
import model.SportsTeam;

public class RunProgram {

	static Scanner in = new Scanner(System.in);
	static SportsTeamHelper sth = new SportsTeamHelper();

	public static void main(String[] args) {
		runMenu();
	}

	private static void addTeam() {
		System.out.print("Enter Team Name: ");
		String team = in.nextLine();
		System.out.print("Enter Team City: ");
		String city = in.nextLine();
		System.out.print("Enter number of Players: ");
		int players = in.nextInt();
		in.nextLine();

		SportsTeam toAdd = new SportsTeam(team, city, players);
		sth.insertTeam(toAdd);
	}

	private static void deleteTeam() {
		// skips if no results found
		if (searchTeams()) {
			System.out.println("Enter id to Delete: ");
			int toDelete = in.nextInt();
			in.nextLine();
			sth.deleteTeam(toDelete);
		}

	}

	public static void editTeam() {
		// skips if no results found
		if (searchTeams()) {
			System.out.println("Enter id to Edit: ");
			int idToEdit = in.nextInt();
			SportsTeam toEdit = sth.searchforTeamById(idToEdit);
			System.out.println("Retrieved Team: " + toEdit.getTeamInfo());
			System.out.println("1 : Update Team Name");
			System.out.println("2 : Update City");
			System.out.println("3 : Update Player Number");
			int update = in.nextInt();
			in.nextLine();
			switch (update) {
			case 1: {
				System.out.println("New Name: ");
				String newName = in.nextLine();
				toEdit.setTeamName(newName);
				break;
			}
			case 2: {
				System.out.println("New City: ");
				String newCity = in.nextLine();
				toEdit.setCity(newCity);
				break;
			}
			case 3: {
				System.out.println("New Player Number: ");
				int newPlayerNumber = in.nextInt();
				in.nextLine();
				toEdit.setPlayerCount(newPlayerNumber);
				break;
			}
			}
			sth.updateTeam(toEdit);
		}
	}

	private static boolean searchTeams() {
		System.out.println("How would you like to search?");
		System.out.println("1 : Search by Team Name");
		System.out.println("2 : Search by City");
		System.out.println("3 : Search by Player Number");
		int searchBy = in.nextInt();
		in.nextLine();
		List<SportsTeam> foundTeams;
		switch (searchBy) {
		case 1: {
			System.out.println("Enter the Team Name: ");
			String teamName = in.nextLine();
			foundTeams = sth.searchforTeamByName(teamName);
			break;
		}
		case 2: {
			System.out.println("Enter the City: ");
			String city = in.nextLine();
			foundTeams = sth.searchforTeamByCity(city);
			break;
		}
		case 3: {
			System.out.println("Enter the Player Number: ");
			int players = in.nextInt();
			in.nextLine();
			foundTeams = sth.searchforTeamByPlayerNumber(players);
			break;
		}
		default: {
			foundTeams = new ArrayList<SportsTeam>();
		}
		}
		if (!foundTeams.isEmpty()) {
			System.out.println("Found Results!");
			for (SportsTeam team : foundTeams) {
				System.out.println(team.getId() + " : " + team.getTeamInfo());
			}
			return true;
		} else {
			System.out.println("--No Results Found--");
			return false;
		}
	}

	public static void viewAllTeams() {
		List<SportsTeam> allTeams = sth.showAllTeams();
		for (SportsTeam team : allTeams) {
			System.out.println(team.getTeamInfo());
		}
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to The Sports Team Database! ---");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Team");
			System.out.println("*  2 -- Edit a Team");
			System.out.println("*  3 -- Delete a Team");
			System.out.println("*  4 -- View All Teams");
			System.out.println("*  5 -- Exit the Program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			switch (selection) {
			case 1:
				addTeam();
				break;
			case 2:
				editTeam();
				break;
			case 3:
				deleteTeam();
				break;
			case 4:
				viewAllTeams();
				break;
			default:
				sth.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
}
