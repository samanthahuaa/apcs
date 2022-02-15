/**
tall mountains(Ruby Friedman and Samantha Hua)
APCS
HW64 -- Revisitation
2022-02-14
time spent: 2.0 hrs
*/
public class triangle {

	/* We have triangle made of blocks. The topmost row has 1
	block, the next row down has 2 blocks, the next row has 3
	blocks, and so on. Compute recursively (no loops or
	multiplication) the total number of blocks in such a 
	triangle with the given number of rows. */
        public static int triangle(int rows) {
                if (rows == 0) {
                        return 0;
                }
		else if (rows == 1) {
			return 1;
		}
                else {
                        return rows + triangle(rows - 1);
                }
        }
        public static void main(String[] args) {
                System.out.println(triangle(0));
                System.out.println(triangle(1));
                System.out.println(triangle(2));
        }
}
