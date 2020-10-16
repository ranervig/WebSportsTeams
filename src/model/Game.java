package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GAME_ID")
	private int id;
	@Column(name = "GAME_LOCATION")
	private String location;
	@Column(name = "GAME_DATE")
	private LocalDate gameDate;
	@Column(name = "HOME_SCORE")
	private int homeScore;
	@Column(name = "AWAY_SCORE")
	private int awayScore;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "HOME_TEAM_ID")
	private SportsTeam homeTeam;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "AWAY_TEAM_ID")
	private SportsTeam awayTeam;

	public Game() {
		super();
	}

	public Game(int id, String location, LocalDate gameDate, int homeScore, int awayScore, SportsTeam homeTeam,
			SportsTeam awayTeam) {
		super();
		this.id = id;
		this.location = location;
		this.gameDate = gameDate;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public Game(int id, String location, LocalDate gameDate, SportsTeam homeTeam, SportsTeam awayTeam) {
		super();
		this.id = id;
		this.location = location;
		this.gameDate = gameDate;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public Game( String location, LocalDate gameDate, int homeScore, int awayScore, SportsTeam homeTeam,
			SportsTeam awayTeam) {
		super();
		this.location = location;
		this.gameDate = gameDate;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public Game(String location, LocalDate gameDate, SportsTeam homeTeam) {
		super();
		this.location = location;
		this.gameDate = gameDate;
		this.homeTeam = homeTeam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getGameDate() {
		return gameDate;
	}

	public void setGameDate(LocalDate gameDate) {
		this.gameDate = gameDate;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public SportsTeam getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(SportsTeam homeTeam) {
		this.homeTeam = homeTeam;
	}

	public SportsTeam getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(SportsTeam awayTeam) {
		this.awayTeam = awayTeam;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", location=" + location + ", gameDate=" + gameDate + ", homeScore=" + homeScore
				+ ", awayScore=" + awayScore + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + "]";
	}

}
