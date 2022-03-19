/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] ranks1 = {"6", "8", "jack", "ace"};
		String[] ranks2 = {"ace", "7"};

      		String[] suits = {"blue", "red", "yellow"};
		String[] suits1 = {"diamonds", "diamonds", "spades", "hearts"};
		String[] suits2 = {"cat", "bird"};

      		int[] pointValues = {11, 12, 13};
      		int[] pointValues1 = {6, 8, 11, 1};
      		int[] pointValues2 = {1, 7};


      		Deck iHateBirds = new Deck(ranks, suits, pointValues);
		Deck slaying = new Deck(ranks1, suits1, pointValues1);
		Deck animalFarm = new Deck(ranks2, suits2, pointValues2);

		System.out.println(iHateBirds.isEmpty());
		int counter = 4;
		while (counter > 0) {
			System.out.println(iHateBirds.deal());
			System.out.println(iHateBirds.size());
			counter --;
		}
		System.out.println(iHateBirds.isEmpty());
		System.out.println(slaying.size());
		System.out.println(animalFarm.size());

	}
}
