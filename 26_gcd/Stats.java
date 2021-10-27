public class Stats {
  public static int gcd( int a, int b ){
    int gcd = 1;
    int counter = 1;
    if (a < b) {
      while (counter < a) {
        if (a%counter == 0 && b%counter == 0) {
          gcd = counter;
        }
        counter++;
      }
    } else {
      while (counter < b) {
          if (a%counter == 0 && b%counter == 0) {
            gcd = counter;
          }
          counter++;
        }
    }
    return gcd;
  }
  
  public static void main(String[] args) {
    gcd(9,15);
    gcd(3,14);
  }
}
