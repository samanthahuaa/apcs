public class helloName {
  public static String helloName(String name) {
    return "Hello "+name+"!";
  }
  
  public static void main(String[] args) {
    helloName("Bob");
    helloName("Alice");
    helloName("X");
  }
}
