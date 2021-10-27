/*
<PENDING TNPG> Yat Long Chan, Samantha Hua, Lindsay Phung
APCS
HW25 -- Do I repeat myself?/ make fence with while loop and recursive fxn.
2021-10-26
time spent: 0.5 hours
*/

public class Repeater {
  public static void main(String[] args){
    System.out.println(fenceW(1));
//     System.out.println();
    System.out.println(fenceW(2));
    System.out.println(fenceW(5));
    
    System.out.println(fenceR(1));
    System.out.println(fenceR(2));
    System.out.println(fenceR(5));
    
    
  }
  
  public static String fenceW(int numPosts) {
    int counter = 1;
    String fence = "|";
    while (counter < numPosts) {
      fence += "--|";
      counter++;
    }
    }
    return fence;
  }
  
  public static String fenceR(int numPosts) {
    String fence = "";
    if (numPosts == 1) {
      fence += "|";
      return fence;
    } else {
      fence += "|--";
      return fence + fenceR(numPosts-1);
    }
    
  }
    
}
