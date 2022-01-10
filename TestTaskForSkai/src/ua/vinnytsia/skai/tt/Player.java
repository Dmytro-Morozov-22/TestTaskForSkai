package ua.vinnytsia.skai.tt;

public class Player {

	private String player;
	private String nickname;
	private String number;
	private String teamName;
	private int ratingPoints;

	public Player() {
		super();
	}
	
	public Player(String player, String nickname, String number,
			String teamName) {
		super();
		this.player = player;
		this.nickname = nickname;
		this.number = number;
		this.teamName = teamName;
		this.ratingPoints = 0;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getRatingPoints() {
		return ratingPoints;
	}

	public void setRatingPoints(int ratingPoints) {
		this.ratingPoints += ratingPoints;
	}

	@Override
	public String toString() {
		return "Player [player=" + player + ", nickname=" + nickname
				+ ", number=" + number + ", teamName=" + teamName
				+ ", ratingPoints=" + ratingPoints + "]";
	}

}
