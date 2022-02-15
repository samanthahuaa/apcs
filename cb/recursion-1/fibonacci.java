/**
tall mountains(Ruby Friedman and Samantha Hua)
APCS
HW64 -- Revisitation
2022-02-14
time spent: 2.0 hrs
*/
public class fibonacci {

        /* Given n of 1 or more, return the factorial of n,
         which is n * (n-1) * (n-2) ... 1. Compute
         the result recursively (without loops).*/
        public static int fibonacci(int n) {
                if (n == 0) {
                        return 0;
                }
		else if (n == 1) {
			return 1;
		}
                else {
                        return fibonacci(n-1) + fibonacci(n-2);
                }
        }
        public static void main(String[] args) {
                System.out.println(fibonacci(0));
                System.out.println(fibonacci(1));
                System.out.println(fibonacci(2));
        }
}
