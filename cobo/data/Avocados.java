import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Avocados {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("https://www.kaggle.com/datasets/neuromusic/avocado-prices/download").load();
      ArrayList<AvocadoPrices> allstns = ds.fetchList("AvocadoPrices", "avocado/date", "avocado/averagePrice", "avocado/type", "avocado/year", "avocado/region", "avocado/volume");
      System.out.println("Total avocado datapoints: " + allstns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a year: ");
      String inputYear = sc.next();
      System.out.println("Avocado Prices in " + inputYear);

      double temp = 5.0;

      for (AvocadoPrices ws : allstns) {
         if (ws.getYear().equals(inputYear)) {
            System.out.println("  " + ws.getAveragePrice());
         }
         if (ws.getAveragePrice() < temp) {
           temp = ws.getAveragePrice();
         }
      }
      System.out.println("The lowest avocado price in the year " + inputYear + " was " + temp);
	}
}
