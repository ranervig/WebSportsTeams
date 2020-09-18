package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class SportsTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String teamName;
	@Column(name="CITY")
	private String city;
	@Column(name="PLAYERS")
	private int playerCount;
	
	public SportsTeam() {
		super();
	}
	
	public SportsTeam(String teamName, String city, int playerCount) {
		super();
		this.teamName = teamName;
		this.city = city;
		this.playerCount = playerCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	
	public String getTeamInfo() {
		return city + " " + teamName + ": " + playerCount + " players";
	}
}
