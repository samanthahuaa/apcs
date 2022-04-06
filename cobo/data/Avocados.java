import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Avocados {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("https://www.kaggle.com/datasets/neuromusic/avocado-prices").load();
      ArrayList<AvocadoPrices> allstns = ds.fetchList("AvocadoPrices", "avocado/date"
             "avocado/averagePrice", "avocado/type",
             "avocado/year", "avocado/region", "avocado/volume");
      System.out.println("Total avocado datapoints: " + allstns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }
	}
}
