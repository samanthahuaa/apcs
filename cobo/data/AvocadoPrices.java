public class AvocadoPrices {
	private String date;
	private double AveragePrice;
	private String type;
  private int year;
  private String Region;
	private int TotalVolume;

   AvocadoPrices(String date, double AveragePrice, String type, int year, String Region, int TotalVolume) {
      this.date = date;
      this.AveragePrice = AveragePrice;
      this.type = type;
      this.year = year;
      this.Region = Region;
      this.TotalVolume = TotalVolume;
   }

	public String getYear() {
 		return "" + year;
 	}

	public double getAveragePrice() {
		return AveragePrice;
	}

   public String getRegion() {
      return Region;
   }
}
