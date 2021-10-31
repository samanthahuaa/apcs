// Return true if the string "cat" and "dog" appear the same number of times in the given string.

public class catDog {
  public static boolean catDog(String str) {
    int catCounter = 0;
    int dogCounter = 0;
    for (int i=0; i < (str.length()-2); i++) {
      if (str.substring(i,i+3).equals("cat")) {
        catCounter++;
      } else if (str.substring(i,i+3).equals("dog")) {
        dogCounter++;
      }
    }
    if (catCounter == dogCounter) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(catDog("catdog"));
    System.out.println(catDog("catcat"));
    System.out.println(catDog("1cat1cadodog"));
  }
}
