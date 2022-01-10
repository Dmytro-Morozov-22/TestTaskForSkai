package ua.vinnytsia.skai.tt;

import java.io.File;
import java.util.ArrayList;

public interface Game {

//The method gets a CSV file and starts to read the file from the second line.
//The method creates an object of a certain type of game and after that returns
//a list of objects namely "playerList". 	
    public ArrayList<Player> createTeam(File file) throws Exception;
	
//The method gets a list of players of a certain game and counts rating points 
//of each player
	public void countRatingPoints(ArrayList<Player> playerList);
	
//The method gets a list of players of a certain game after that the method 
//defines and returns a list of players of a winning team 
	public ArrayList<Player> defineWinnerTeam(ArrayList<Player> playerList);
	
//This method is the default. It means that can be used by a player of any game.
//The method gets the winning team and adds 10 points to the rating points of 
//each player
	default void add10PointsToWinnerTeam(ArrayList<Player> winnerTeam) {
		for(Player player: winnerTeam) {
			player.setRatingPoints(10);
		}
	}
	
}
