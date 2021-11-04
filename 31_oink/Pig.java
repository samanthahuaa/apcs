/***
 * Quad Puffs
 * APCS
 * HW31 --
 * 2021-11-03
 * time spent: _hrs
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: It allows us to reference all of the vowels at once.
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    if (w.indexOf(letter) != -1) {
      return true;
    } else {
      return false;
    }
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    for (int i=0; i < VOWELS.length(); i++) {
      if (letter.indexOf(VOWELS.substring(i, i+1)) != -1) {
        return true;
      }
    }
    return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    int counter = 0;
    for (int j=0; j < w.length(); j++) {
      String character = w.substring(j,j+1);
      for (int i=0; i < VOWELS.length(); i++) {
        if (character.indexOf(VOWELS.substring(i, i+1)) != -1) {
          counter++;
        }
      }
    }
    return counter;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
    for (int j=0; j < w.length(); j++) {
      String character = w.substring(j,j+1);
      for (int i=0; i < VOWELS.length(); i++) {
        if (character.indexOf(VOWELS.substring(i, i+1)) != -1) {
          return true;
        }
      }
    }
    return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    String answer = "";
    for (int j=0; j < w.length(); j++) {
      String character = w.substring(j,j+1);
      for (int i=0; i < VOWELS.length(); i++) {
        if (character.indexOf(VOWELS.substring(i, i+1)) != -1) {
          answer += character;
        }
      }
    }
    return answer;
  }


  public static void main( String[] args )
  {
    System.out.println(hasA("boop","a"));
    System.out.println(hasA("boop","p"));
    System.out.println();

    System.out.println(isAVowel("i"));
    System.out.println(isAVowel("l"));
    System.out.println();

    System.out.println(countVowels("meatball"));
    System.out.println(countVowels("the quick brown fox jumps over the lazy dog"));
    System.out.println();

    System.out.println(hasAVowel("boop"));
    System.out.println(hasAVowel("gym"));
    System.out.println();

    System.out.println(allVowels("meatball"));
    System.out.println(allVowels("markers"));

  }//end main()

}//end class Pig
