/*
AllBread (Ivina Wang, Jacc Chen, Samantha Hua)
APCS
HW56: Turing Training Wheels
2022-01-12
time spent: 2 hrs
*/

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	 /*
	 		The chatbox will only return one response and this because all of the
			keywords are searched for in the same for loop. So once the first keyword
			is found, the rest of the keywords are ignored. We can prioritize certain
			responses over others by putting them further up in the if statement.
	 */
	 /*
	 		The problem is that certain words may be located inside other words that
			take on different meanings. (ex: no inside know and mother inside smother)
			The chatbox will return a response to the keyword inside the larger word which
			sometimes make sense.
	 */
	public String getResponse(String statement)
	{
		statement = statement.trim();
		String response = "";

		if (statement.length() == 0) {
			response = "Say something, I'm giving up on youuuuuu";
		}
		else if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0)
		{
			response = "Tell me more about your pets. pspspspspsp";
		}
		else if (statement.indexOf("Mykolyk") >= 0)
		{
			response = "Ooo he is my teacher as well. isn't class always interesting?";
		}
		else if (statement.indexOf("Earth") >= 0)
		{
			response = "Ah yes the blue marble";
		}
		else if (statement.indexOf("turtle") >= 0)
		{
			response = "sksksksksksksks";
		}
		else if (statement.indexOf("school") >= 0)
		{
			response = "-_-";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "no lies detected";
		}
		else if (whichResponse == 5) {
			response = "Excuse me?????";
		}

		return response;
	}
}
