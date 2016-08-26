package ssa;

public class BowlingGame {
	int k = 1;
	int total;
	int gameCounter = 0;
	int seriesCounter = 0;
	int bowlingScores[][] = new int[3][11];
	static java.util.Random rnd = new java.util.Random((new java.util.Date()).getTime());

	private int rollOneBall() {
		return rnd.nextInt(10);
	}

	private int oneFrame() {
		int roll1 = rollOneBall();

		int roll2 = 0;
		if (roll1 < 10) {
			roll2 = rollOneBall();
		}
		int total = roll1 + roll2;

		if (total > 10) {
			return 10;
		} else {
			return total;
		}
	}

	public void bowl() {

		System.out.println("Frames\t     1\t      2\t       3\t4\t 5\t  6\t   7\t    8\t     9\t     10     Total");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");

		for (int game = 0; game < 3; game++) {
			gameCounter = 0;
			for (int frame = 0; frame < 10; frame++) {
				bowlingScores[game][frame] = oneFrame();
				gameCounter += bowlingScores[game][frame];
			}
			bowlingScores[game][10] = gameCounter;
			seriesCounter += gameCounter;

		}

		for (int[] game : bowlingScores) {
			System.out.print("Game" + k);
			k++;

			for (int frame : game) {

				System.out.printf("     " + String.format("%4d", frame));
			}
			System.out.println("");
		}
		System.out.println("Total Series:\t\t\t\t\t\t\t\t\t\t\t     " + seriesCounter);

	}
}
