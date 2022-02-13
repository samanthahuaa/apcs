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

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
  private static ArrayList<String> strongPosAdjectives = new ArrayList<String>();
  private static ArrayList<String> strongNegAdjectives = new ArrayList<String>();

  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

    //read in the strong positive adjectives in strongPositiveAdjectives.txt
       try {
        Scanner input = new Scanner(new File("strongPositiveAdjectives.txt"));
        while(input.hasNextLine()){
          String temp = input.nextLine().trim();
          strongPosAdjectives.add(temp);
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing strongPostitiveAdjectives.txt\n" + e);
      }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }

    //read in the strong negative adjectives in strongNegativeAdjectives.txt
       try {
        Scanner input = new Scanner(new File("strongNegativeAdjectives.txt"));
        while(input.hasNextLine()){
          String temp = input.nextLine().trim();
          strongNegAdjectives.add(temp);
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing strongNegativeAdjectives.txt\n" + e);
      }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a strong positive adjective from the strongPositiveAdjectives.txt file and returns it.
   */
  public static String randomStrongPositiveAdj()
  {
    int index = (int)(Math.random() * strongPosAdjectives.size());
    return strongPosAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
// Summarize your experience in your readme file.
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a strong negative adjective from the strongNegativeAdjectives.txt file and returns it.
   */
  public static String randomStrongNegativeAdj()
  {
    int index = (int)(Math.random() * strongNegAdjectives.size());
    return strongNegAdjectives.get(index);
  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      if (Math.random() < .5) {
        return randomPositiveAdj();
      } else {
        return randomStrongPositiveAdj();
      }
    } else {
      if (Math.random() < .5) {
        return randomNegativeAdj();
      } else {
        return randomStrongNegativeAdj();
      }
    }
  }

  // there is a weird error where a double with more than two decimal places
  // is returned --> seems like a issue with double subtraction --> tested with
  // other doubles and variables
  public static double totalSentiment(String filename) {
    String input = removePunctuation(textToString(filename));
    double counter = 0.0;
    int lastIndexOfWord = 0;
    for(int i=0; i < input.length(); i++){
      if(Character.isWhitespace(input.charAt(i))){
        counter += sentimentVal(input.substring(lastIndexOfWord,i));
        lastIndexOfWord = i+1;
      }
    }
    return counter;
  }

  public static int starRating(String fileName) {
    if (totalSentiment(fileName) < 0) {
      return 1;
    } else if (totalSentiment(fileName) < 5) {
      return 2;
    } else if (totalSentiment(fileName) < 10) {
      return 3;
    } else if (totalSentiment(fileName) < 15) {
      return 4;
    } else {
      return 5;
    }
  }

  public static String fakeReview(String filename) {
    String input = textToString(filename);
    String output = "";
    for(int i=0; i < input.length(); i++){
      if((input.charAt(i)) == '*'){
        while (!Character.isWhitespace(input.charAt(i))) {
          i++;
        }
        output += randomAdjective();
      }
      output += input.charAt(i);
    }
    return output;
  }

  public static void main(String[] args) {
    // #1b
    // System.out.println(sentimentVal(5));

    // #2
    // System.out.println(sentimentVal("hot"));
    // System.out.println(sentimentVal("acceptable"));
    // System.out.println(sentimentVal("terrible"));

    // #3
    // System.out.println(totalSentiment("SimpleReview.txt"));

    // Activity 3 #4
    System.out.println(fakeReview("SimpleReview.txt"));
  }
}
