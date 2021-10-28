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
  
  public static int gcdER( int a, int b ) {
    if (a == b) {
      return a;
    } else {
      if (a > b) {
        return gcd(a-b,b);
      } else {
        return gcd(b-a,a);
      }
    }
  }
  
  public static void main(String[] args) {
    System.out.println(gcd(9,15));
    System.out.println(gcd(3,14));
    
    System.out.println(gcdER(9,15));
    System.out.println(gcdER(3,14));
  }
}
