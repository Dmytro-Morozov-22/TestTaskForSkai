package ua.vinnytsia.skai.tt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Tournament {

//The map "raitingList" saves nicknames and rating points of each player of 
//the tournament
	private Map<String, Integer> ratingList = new TreeMap<String, Integer>();

	public Map<String, Integer> getRatingList() {
		return ratingList;
	}

//The method gets a list of players for each game. If map "raitingList" is empty
//method puts the nickname and rating points of each player into the map. if map
//"raitingList" is not empty the method adds rating points to each existing 
//nickname in the map. If the map does not contain the nickname the method adds 
//a new nickname and rating point into the map.
	public void addToRatingList(ArrayList<Player> createdObjects) {

		Map<String, Integer> copy = new TreeMap<String, Integer>(ratingList);

		if (ratingList.isEmpty()) {
			for (Player player : createdObjects) {
				ratingList.put(player.getNickname(), player.getRatingPoints());
			}
		} else {

			for (Player player : createdObjects) {
				int i = 0;
				Iterator<Entry<String, Integer>> iterator = copy.entrySet()
						.iterator();
				while (iterator.hasNext()) {

					Entry<String, Integer> next = iterator.next();

					if (next.getKey().equals(player.getNickname())) {
						ratingList.put(next.getKey(),
								next.getValue() + player.getRatingPoints());
					}

					else if (!next.getKey().equals(player.getNickname())) {
						i++;
					}

				}

				if (copy.size() == i)
					ratingList.put(player.getNickname(),
							player.getRatingPoints());

			}

		}

	}

//The method displays the map "raitingList" to the console.
	public void displayToConsole() {
		System.out.println(ratingList);
	}

//The method defines the most valuable player of the tournament.
	public void defineMVP() {

		int maxValue = (Collections.max(ratingList.values()));
		Iterator<Entry<String, Integer>> iterator = ratingList.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			if (next.getValue() == maxValue) {
				System.out.println("MVP is a player with nickname \""
						+ next.getKey() + "\". He scored  " + next.getValue()
						+ " points");
			}

		}

	}

}
