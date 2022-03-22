// Maine Lobsters: Samantha Hua, Ruby Friedman, Nada Hameed
// APCS
// L07: But These Go Up To Eleven
// 2022-03-21
// time spent: 6.7 hrs

/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new ElevensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
