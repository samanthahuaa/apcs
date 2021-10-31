// Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

public class countCode {
  public static int countCode(String str) {
    int counter = 0;
    for (int i=0; i<(str.length()-3); i++) {
      if (str.substring(i,i+2).equals("co")) {
        if (str.substring(i+3,i+4).equals("e")) {
          counter++;
        }
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    System.out.println(countCode("aaacodebbb"));
    System.out.println(countCode("codexxcode"));
    System.out.println(countCode("cozexxcope"));
  }

}
