/**
tall mountains(Ruby Friedman and Samantha Hua)
APCS
HW64 -- Revisitation
2022-02-14
time spent: 2.0 hrs
*/
public class count7 {

	/*Given a non-negative int n, return the count of the
	occurrences of 7 as a digit, so for example 717 yields 2.
	(no loops). Note that mod (%) by 10 yields the rightmost
	digit (126 % 10 is 6), while divide (/) by 10 removes the
	rightmost digit (126 / 10 is 12).*/
        public static int count7(int n) {
		if ((n != 7) && (n < 10)) {
			return 0;
		}
		else if (n == 7) {
			return 1;
		}
		else {
			return count7(n%10) + count7(n/10);
		}
        }
        public static void main(String[] args) {
                System.out.println(count7(717));
                System.out.println(count7(7));
                System.out.println(count7(123));
        }
}
