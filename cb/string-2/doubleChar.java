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
