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
    if (numPosts == 1) {
      return fence;
    } else {
      while (counter < numPosts) {
        fence += "--|";
        counter++;
      }
    }
    return fence;
  }
  
  public static String fenceR(int numPosts) {
    if (numPosts == 1) {
      fence += "|";
      return fence;
    } else {
      fence += "|--";
      
      fenceR(numPosts-1);
      return fence;
    }
    
  }
    
}
