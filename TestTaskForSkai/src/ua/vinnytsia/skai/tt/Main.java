package ua.vinnytsia.skai.tt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
//1. Creating an object of the tournament.
		Tournament tournament = new Tournament();

		try {
			File folder = new File("CSV_files");

//2. Checking for the wrong format of files
			for (File file : folder.listFiles()) {
				if (!(file.getName().contains(".csv"))) {
					throw new WrongFileFormatException();
				}
			}

//3. Checking for the uniqueness of the nicknames in each game
			Set<String> uniqueNicknames = new HashSet<String>();
			for (File file : folder.listFiles()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String fileName = file.getName();
				br.readLine();
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] c = line.split(";");
					boolean checkForUnique = uniqueNicknames.add(c[1]);
					if (!checkForUnique) {
						System.out.println("The file \"" + fileName
								+ "\" contains players with the same nicknames \""
								+ c[1] + "\"");
						br.close();
						throw new NotUniqueNicknameException();

					}
				}
				br.close();
				uniqueNicknames.clear();
			}

			for (File file : folder.listFiles()) {
				String firstLine = "";
				BufferedReader br = new BufferedReader(new FileReader(file));
				firstLine = br.readLine().toUpperCase();
//4. Defining the type of game. If you want to add one more game you must add
//one more "else if" statement for new game
				if (firstLine.contains("BASKETBALL")) {
//5. Calling a method "createTeam(file)" and assigning a result to createdObjects
					BasketballPlayer basketball = new BasketballPlayer();
					ArrayList<Player> createdObjects = basketball
							.createTeam(file);
//6. Counting rating points of each object
					basketball.countRatingPoints(createdObjects);

//7. Calling a method "defineWinnerTeam(createdObjects)" and assigning a result to winnerTeam
					ArrayList<Player> winnerTeam = basketball
							.defineWinnerTeam(createdObjects);

//8. Calling a default method "add10PointsToWinnerTeam(winnerTeam)"
					basketball.add10PointsToWinnerTeam(winnerTeam);

//9. Calling a method "addToRatingList(createdObjects)"
					tournament.addToRatingList(createdObjects);

				} else if (firstLine.contains("HANDBALL")) {
					HandballPlayer handball = new HandballPlayer();
					ArrayList<Player> createdObjects = handball
							.createTeam(file);
					handball.countRatingPoints(createdObjects);

					ArrayList<Player> winnerTeam = handball
							.defineWinnerTeam(createdObjects);
					handball.add10PointsToWinnerTeam(winnerTeam);

					tournament.addToRatingList(createdObjects);

				}

				br.close();

			}

//10. Displaying all players to the console
			tournament.displayToConsole();
//11. Calling the method "definingMVP" for defining Most Valuable Player
			tournament.defineMVP();

		} catch (WrongFileFormatException e) {
			System.out.println(e);
		} catch (NotUniqueNicknameException e) {
			System.out.println(e);
		}

	}

}
