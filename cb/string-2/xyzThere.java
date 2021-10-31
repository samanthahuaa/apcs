// Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

public class xyzThere {
  public static boolean xyzThere(String str) {
    boolean result = false;
    for (int i=0; i<str.length()-2; i++) {
      if (str.substring(i,i+3).equals("xyz")) {
        if (i == 0) {
          result = true;
        } else if (str.substring(i-1,i).equals(".")) {
          result = false;
        } else {
          result = true;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(xyzThere("abcxyz"));
    System.out.println(xxyzThere("abc.xyz"));
    System.out.println(xyzThere("xyz.abc"));
  }
}
