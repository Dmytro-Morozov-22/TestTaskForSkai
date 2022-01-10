package ua.vinnytsia.skai.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class BasketballPlayer extends Player implements Game {

	private int rebounds;
	private int assists;
	private int scoredPoints;

	public BasketballPlayer() {
		super();
	}

	public BasketballPlayer(String player, String nickname, String number,
			String teamName, int rebounds, int assists, int scoredPoints) {
		super(player, nickname, number, teamName);
		this.rebounds = rebounds;
		this.assists = assists;
		this.scoredPoints = scoredPoints;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getScoredPoints() {
		return scoredPoints;
	}

	public void setScoredPoints(int scoredPoints) {
		this.scoredPoints = scoredPoints;
	}

	@Override
	public String toString() {
		return "Basketball [rebounds=" + rebounds + ", assists=" + assists
				+ ", scoredPoints=" + scoredPoints + ", getPlayer()="
				+ getPlayer() + ", getNickname()=" + getNickname()
				+ ", getNumber()=" + getNumber() + ", getTeamName()="
				+ getTeamName() + ", getRatingPoints()=" + getRatingPoints()
				+ "]";
	}

	@Override
	public ArrayList<Player> createTeam(File file) throws Exception {

		ArrayList<Player> playerList = new ArrayList<Player>();
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();

		while ((line = br.readLine()) != null) {
			String[] c = line.split(";");

			playerList.add(new BasketballPlayer(c[0], c[1], c[2], c[3],
					Integer.parseInt(c[5]), Integer.parseInt(c[6]),
					Integer.parseInt(c[4])));
		}
		br.close();
		return playerList;

	}


	@Override
	public void countRatingPoints(ArrayList<Player> playerList) {
		for (Player player : playerList) {
			player.setRatingPoints(
					((BasketballPlayer) player).getScoredPoints() * 2
							+ ((BasketballPlayer) player).getRebounds() * 1
							+ ((BasketballPlayer) player).getAssists() * 1);
		}

	}


	@Override
	public ArrayList<Player> defineWinnerTeam(ArrayList<Player> playerList) {
		int scoredPoints_A = 0;
		int scoredPoints_B = 0;

		ArrayList<Player> winnerTeam = new ArrayList<Player>();

		String firstTeam = playerList.get(0).getTeamName();

		for (Player player : playerList) {

			if (player.getTeamName().equals(firstTeam)) {
				scoredPoints_A += ((BasketballPlayer) player).getScoredPoints();
			} else {
				scoredPoints_B += ((BasketballPlayer) player).getScoredPoints();
			}

		}

		if (scoredPoints_A > scoredPoints_B) {
			for (Player player : playerList) {
				if (player.getTeamName().equals(firstTeam))
					winnerTeam.add(player);
			}

		} else {
			for (Player player : playerList) {
				if (!player.getTeamName().equals(firstTeam))
					winnerTeam.add(player);
			}

		}

		return winnerTeam;
	}

}// Basketball
