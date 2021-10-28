/*
   Interesting Pandas -- Yat long Chan / Samantha Hua / Lindsay Phung
   APCS
   HW26 -- GCD Three Ways
   2021-10-27
   time spent: 0.5 hours
   DISCO
   - There are many different different algos that can solve the same problem.
   QCC
   - Which method would be the quickest or most efficient?
   ALGO
   Note: We know that if the larger number is replaced with the difference of the larger - smaller, the GCD remains the same.
   0) If a is equal to b, return either one of them. We chose to return a.
   1) Otherwise, check if a > b.
   2) If a > b, then we would find the difference of a - b and use that in step 3.
   2.5) Otherwise, if a < b, we would find the difference of b - a and use that in step 3. These steps are important so that both inputs are positive.
   3) We then substitute inputs a and b with the difference found in step 2 or 2.5 and the smaller number, respectively.
   4) Use the new inputs to run through steps 0-3 until the two inputs are equal.
 */
public class Stats {
  public static int gcd( int a, int b ){
    int gcd = a;
    int counter = 1;
    if (a == b) {
      return gcd;
    } else if (a < b) {
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
    } else if (a > b){
        return gcd(a-b,b);
    } else {
        return gcd(b-a,a);
    }
  }
  
  public static int gcdEW( int a, int b ) {
    while (a != b) {
      if (a > b) {
        a = a-b;
      } else {
        b=b-a;
      }
    }
    return a;
  }
  
  public static void main(String[] args) {
    System.out.println(gcd(9,15));
    System.out.println(gcd(3,14));
    
    System.out.println(gcdER(9,15));
    System.out.println(gcdER(3,14));
    
    System.out.println(gcdEW(9,15));
    System.out.println(gcdEW(3,14));
  }
}
