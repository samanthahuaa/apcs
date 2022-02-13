// Rotating Cocoa (Samantha Hua, Perry Huang, Eric He)
// APCS pd. 7
// HW63: Read/Review/Expand
// 2022-02-10
// time spent: 3 hours

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class madLibs {

  private static ArrayList<String> adjectives = new ArrayList<String>();
  private static ArrayList<String> adverbs = new ArrayList<String>();
  private static ArrayList<String> nouns = new ArrayList<String>();
  private static ArrayList<String> names = new ArrayList<String>();

  static{
  //read in the adjectives in madAdj.txt
     try {
      Scanner input = new Scanner(new File("madAdj.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        adjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing madAdj.txt\n" + e);
    }

    //read in the adverbs in madAdv.txt
       try {
        Scanner input = new Scanner(new File("madAdv.txt"));
        while(input.hasNextLine()){
          String temp = input.nextLine().trim();
          adverbs.add(temp);
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing madAdv.txt\n" + e);
      }

  //read in the nouns in madNoun.txt
     try {
      Scanner input = new Scanner(new File("madNoun.txt"));
      while(input.hasNextLine()){
        nouns.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing madNoun.txt");
    }

    //read in the names in madName.txt
       try {
        Scanner input = new Scanner(new File("madName.txt"));
        while(input.hasNextLine()){
          String temp = input.nextLine().trim();
          names.add(temp);
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing madName.txt\n" + e);
      }
  }

  /**
   * Randomly picks a adjective from the madAdj.txt file and returns it.
   */
  public static String randomAdj()
  {
    int index = (int)(Math.random() * adjectives.size());
    return adjectives.get(index);
  }

  /**
   * Randomly picks a adverb from the madAdv.txt file and returns it.
   */
  public static String randomAdv()
  {
    int index = (int)(Math.random() * adverbs.size());
    return adverbs.get(index);
  }

  /**
   * Randomly picks a noun from the madNoun.txt file and returns it.
   */
// Summarize your experience in your readme file.
  public static String randomNoun()
  {
    int index = (int)(Math.random() * nouns.size());
    return nouns.get(index);

  }

  /**
   * Randomly picks a name from the madName.txt file and returns it.
   */
  public static String randomName()
  {
    int index = (int)(Math.random() * names.size());
    return names.get(index);
  }

  public static String announcement(double a) {
    if (a < .5) {
      return "Preach! This story is so compelling!";
    } else {
      return "ngl, that was pretty disappointing...";
    }
  }

  public static String nameVowel(String s) {
    if (s.charAt(0) == 'E') {
      return "Your character's name begins with a vowel!";
    } else {
      return "womp womp womp your character's name does not begin with a vowel";
    }
  }

  public static int nounLength(String s) {
    return s.length();
  }

  public static void main(String[] args) {
    String s = "";
    String name = randomName();
    String noun = randomNoun();

    s += name;
    s += " went down the road. They were ";
    s += randomAdj() + " and " + randomAdj();
    s += " today. But their day was a lot better when they ";
    s += randomAdv();
    s += " ate a ";
    s += noun;

    System.out.println(s);

    double rand = Math.random();
    System.out.println("\n" + announcement(rand));

    s = "\nHere are some cool facts! \n";
    s += nameVowel(name);
    s += "\nThe noun that was picked is ";
    s += nounLength(noun);
    s += " characters long";

    System.out.println(s);
  }
}
