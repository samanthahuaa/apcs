// Given a string, return a string where for every char in the original, there are two chars.

public class doubleChar {
  public static String doubleChar(String str) {
    String answer = "";
      for (int i=0; i <str.length(); i++) {
        answer += (str.substring(i,i+1));
        answer += (str.substring(i,i+1));
      }
    return answer;
  }
  
  public static void main(String[] args) {
    System.out.println(doubleChar("The"));
    System.out.println(doubleChar("Hi-There"));
    System.out.println(doubleChar(""));
  }
}
