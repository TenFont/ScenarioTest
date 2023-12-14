package org.tenfont.scenariotest;

public class Main {
    int LeagueSize = 5;
    int MatchNo = 8;
    String[] TeamName = {
            "TeamA",
            "TeamB",
            "TeamC",
            "TeamD",
            "TeamE"
    };
    int[][] TeamPoints = {
            {0, 3, 2, 3, 3, 1, 0, 2},
            {2, 1, 1, 3, 1, 2, 2, 3},
            {3, 0, 0, 2, 1, 3, 0, 1},
            {1, 1, 3, 2, 3, 2, 3, 3},
            {3, 2, 2, 0, 2, 3, 3, 0},
    };

    public void solution() {
        // Declare variables to keep track of the current team with the maximum/minimum no. of points
        int maxPoints = 0, minPoints = -1;
        String maxPointsTeamName = "none", minPointsTeamName = "none";

        // Loop each team in the array
        for (int i = 0; i < LeagueSize; i++) {
            // Calculate the total points and no. of wins of each type
            // I forgot what each win type is supposed to stand for, so I'm using arbitrary variable names
            int totalPoints = 0,
                    noWins0 = 0,
                    noWins1 = 0,
                    noWins2 = 0,
                    noWins3 = 0;
            for (int j = 0; j < MatchNo; j++) {
                // increment variable based on type of win
                switch (TeamPoints[i][j]) {
                    case 0 -> noWins0++;
                    case 1 -> noWins1++;
                    case 2 -> noWins2++;
                    case 3 -> noWins3++;
                }
                totalPoints += TeamPoints[i][j];
            }
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                maxPointsTeamName = TeamName[i];
            }
            if (minPoints < 0 || totalPoints < minPoints) {
                minPoints = totalPoints;
                minPointsTeamName = TeamName[i];
            }
            System.out.println("\n== Team Name: " + TeamName[i] + " ==");
            System.out.println("noWins0 = " + noWins0);
            System.out.println("noWins1 = " + noWins1);
            System.out.println("noWins2 = " + noWins2);
            System.out.println("noWins3 = " + noWins3);
            System.out.println("Total points = " + totalPoints);
        }
        System.out.println("\nTeam with highest points = " + maxPointsTeamName);
        System.out.println("Team with lowest points = " + minPointsTeamName);
    }


    public static void main(String[] args) {
        new Main().solution();
    }
}
