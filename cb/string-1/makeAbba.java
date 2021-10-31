// Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".

public class makeAbba {
  public static String makeAbba(String a, String b) {
    return a+b+b+a;
  }
  
  public static void main(String[] args) {
    System.out.println(makeAbba("Hi", "Bye"));
    System.out.println(makeAbba("x", ""));
    System.out.println(makeAbba("", "y"));
  }
}
