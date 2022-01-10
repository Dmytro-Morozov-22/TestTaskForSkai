# TestTaskForSkai
Tucan Tournament is a tournament where several players compete in several sports. Right now, the sports played are basketball and handball games. 
They plan to add more sports in the future.

Description of the program
1. The program creates the object of the tournament which will be used farther in the program.
2. The program checks files in the “CSV_files” folder for the wrong format of the files.
3. The program checks for the uniqueness of the nicknames in each game.
4. The program defines the type of the game currently it can be handball or basketball.
5. If the first row of the CSV file contains word “basketball” the program will create an object of basketball. Next, the program uses the object “basketball” 
and calls the method “createTeam” and passes a CSV file to this method. The method returns a list of objects which will be assigned to the list “createdObjects”. 
6. The program uses the object “basketball” and calls the method “countRatingPoints” and passes the list “createdObjects” to this method. The method counts the 
rating points of each player in the list. 
7. The program uses the object “basketball” and calls the method “defineWinnerTeam” and passes to this method the list “createdObjects”. The method defines 
the winning team and returns the list of players of the winning team which is assigned to the list “winnerTeam”.
8. The program uses the object “basketball” and calls the method “add10PointsToWinnerTeam” and passes the list “winnerTeam”. The method adds 10 points to each player 
of the winning team.
9. Now the program uses the object “tournament” and calls the method “addToRatingList” and passes the list “createdObjects” to this method. 
If the map "raitingList" is empty method puts the nickname and rating points of each player into the map. if map "raitingList" is not empty the method adds rating 
points to each existing nickname in the map. If the map does not contain the nickname the method adds a new nickname and rating point into the map.
10. The program uses the object “tournament” and calls the method “displayToConsole”. The method displays the map “ratingList” to the console.
11. The program uses the object “tournament” and calls the method “defineMVP”. The method displays the nickname and rating points of the most valuable player of the tournament.
* If the program defines the word “handball” on the fifth step. All methods which were used to “basketball” object will be used to “handball” object.
