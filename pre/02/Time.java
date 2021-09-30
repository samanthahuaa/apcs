public class Time{
  public static void main(String[] args){
    int hour = 21;
    int minute = 51;
    int second = 49;
    System.out.println("Number of seconds since midnight:");
    System.out.println(hour*3600+minute*60+second);
    System.out.println("Number of seconds left in the day:");
    System.out.println((60*60*24)-(hour*3600+minute*60+second));
    System.out.println("Percentage of the day that has passed:");
    System.out.println((hour*3600+minute*60+second)*100 / (60*60*24));
    int hour1 = 22;
    int minute1 = 19;
    int second1 = 25;
    System.out.println("The number of seconds I spent on this project is:");
    System.out.println((hour1*3600+minute1*60+second1)-(hour*3600+minute*60+second));
  }
}
