// Maine Lobsters: Samantha Hua, Ruby Friedman, Nada Hameed
// APCS
// L07: But These Go Up To Eleven
// 2022-03-21
// time spent: 6.7 hrs

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card yassification = new Card("jack", "hearts", 11);
		Card goodbye = new Card("7", "diamonds", 7);
		Card yehaw = new Card("4", "clubs", 4);
		Card slaying = new Card("jack", "hearts", 11);

		System.out.println(goodbye.suit());
		System.out.println(yehaw.pointValue());
		System.out.println(goodbye);
		System.out.println(yassification);
		System.out.println(yassification.matches(slaying));
		System.out.println(yassification.matches(goodbye));
	}
}
