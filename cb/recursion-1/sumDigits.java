/**
tall mountains(Ruby Friedman and Samantha Hua)
APCS
HW64 -- Revisitation
2022-02-14
time spent: 2.0 hrs
*/
public class sumDigits {

	/* Given a non-negative int n, return the sum of its digits
	recursively (no loops). Note that mod (%) by 10 yields the 
	rightmost digit (126 % 10 is 6), while divide (/) by 10 
	removes the rightmost digit (126 / 10 is 12). */
        public static int sumDigits(int n) {
                if (n < 10) {
                        return n;
                }
                else {
                        return sumDigits(n/10)+ sumDigits(n%10);
                }
        }
        public static void main(String[] args) {
                System.out.println(sumDigits(126));
                System.out.println(sumDigits(49));
                System.out.println(sumDigits(12));
        }
}
