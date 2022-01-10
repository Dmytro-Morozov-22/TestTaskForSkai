package ua.vinnytsia.skai.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HandballPlayer extends Player implements Game {

	private int goalMade;
	private int goalReceived;

	public HandballPlayer() {
		super();
	}

	public HandballPlayer(String player, String nickname, String number,
			String teamName, int goalMade, int goalReceived) {
		super(player, nickname, number, teamName);
		this.goalMade = goalMade;
		this.goalReceived = goalReceived;
	}

	public int getGoalMade() {
		return goalMade;
	}

	public void setGoalMade(int goalMade) {
		this.goalMade = goalMade;
	}

	public int getGoalReceived() {
		return goalReceived;
	}

	public void setGoalReceived(int goalReceived) {
		this.goalReceived = goalReceived;
	}

	@Override
	public String toString() {
		return "Handball [goalMade=" + goalMade + ", goalReceived="
				+ goalReceived + ", getPlayer()=" + getPlayer()
				+ ", getNickname()=" + getNickname() + ", getNumber()="
				+ getNumber() + ", getTeamName()=" + getTeamName()
				+ ", getRatingPoints()=" + getRatingPoints() + "]";
	}

	@Override
	public ArrayList<Player> createTeam(File file) throws Exception {

		ArrayList<Player> playerList = new ArrayList<Player>();
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();

		while ((line = br.readLine()) != null) {
			String[] c = line.split(";");

			playerList.add(new HandballPlayer(c[0], c[1], c[2], c[3],
					Integer.parseInt(c[4]), Integer.parseInt(c[5])));
		}
		br.close();
		return playerList;

	}

	@Override
	public void countRatingPoints(ArrayList<Player> playerList) {

		for (Player player : playerList) {
			player.setRatingPoints(((HandballPlayer) player).getGoalMade() * 2
					+ ((HandballPlayer) player).getGoalReceived() * (-1));
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
				scoredPoints_A += ((HandballPlayer) player).getGoalMade();
			} else {
				scoredPoints_B += ((HandballPlayer) player).getGoalMade();
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

}
