public class Repeater {
  public static void main(String[] args){
    fenceW(1);
    fenceW(2);
    fenceW(5);
  }
  
  public static String fenceW(int numPosts) {
    int counter = 0;
    String fence = "|";
    return fence;
    if (numPosts == 1) {
      
    } else {
      while (counter < numPosts) {
        fence += "--|";
        counter++;
     }
    }
    return fence;
  }
}
