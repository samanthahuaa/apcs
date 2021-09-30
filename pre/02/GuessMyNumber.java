import java.util.Scanner;
import java.util.Random;

public class GuessMyNumber {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    Random random = new Random();
    double line;
    int number = random.nextInt(100) +1;

    System.out.println("I'm thinking of a number from 1 to 100 (including both). Can you guess what it is?");

    System.out.print("Type a number: ");
    line = in.nextDouble();
    System.out.println("You said: "+(int)line);

    int difference = number - (int)line;
    System.out.println("The number I was thinking of is: "+number);
    System.out.print("You were off by: "+Math.abs(difference));

  }
}
