public class Greet {
  public BigSib() {
    helloMsg = "Word up";
  }
  
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib();
//     richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } 
} 
