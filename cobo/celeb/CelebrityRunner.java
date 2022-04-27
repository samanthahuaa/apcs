/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */
import java.util.Scanner;

public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */
	public static void main(String [] args)
	{
		CelebrityGame game = new CelebrityGame();
		game.prepareGame();

		System.out.println("bloop bloop the game has begun.");

		System.out.println("Would you like to continue? Type \"STOP\" to stop");
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		// the user wants to keep playing
		while (!statement.equals("STOP")) {
			// enter a clue
			System.out.println("enter a clue for a celebrity: ");
			in = new Scanner (System.in);
			String clue = in.nextLine();

			// check validity of clue
			if (!game.validateClue(clue, "general")) {
				// if the clue is not valid, keep trying until it is
				while (!game.validateClue(clue, "general")) {
					System.out.println("invalid clue. make sure your clue is at least 10 characters long");
					System.out.println("enter a clue for a celebrity: ");
					in = new Scanner (System.in);
					clue = in.nextLine();
				}
			}

			// enter the celebrity answer
			System.out.println("enter who the celebrity is: ");
			in = new Scanner (System.in);
			String answer = in.nextLine();

			// check validity of answer
			if (!game.validateCelebrity(answer)) {
				// if the celeb is not valid, keep trying until it is
				while (!game.validateCelebrity(answer)) {
					System.out.println("invalid celebrity. make sure your celebrity is at least 4 characters long");
					System.out.println("enter who the celebrity is: ");
					in = new Scanner (System.in);
					answer = in.nextLine();
				}
			}

			// add the celebrity to the game
			game.addCelebrity(answer, clue, "general");

			// does the user want to enter another celebrity
			System.out.println("Would you like to continue? Type \"STOP\" to stop");
			in = new Scanner (System.in);
			statement = in.nextLine();
		}
	}
	// all of the celebrities have been added to the game

	System.out.println("now we are going to play the game!!!!");

	while (game.getCelebrityGameSize() > 0) {
		System.out.println("enter a gues");

	}
}
