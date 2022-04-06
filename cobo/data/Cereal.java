public class Cereal {
  //instance vars
  private String brand;
  private int calNum;

  public Cereal(String b, int c) {
    brand = b;
    calNum = c;
  }

  public String getBrand() {
    return brand;
  }


  public int getcalNum() {
    return calNum;
  }

  public static String compare(Cereal a, Cereal b) {
	if (a.getcalNum() > b.getcalNum()) {
	  return a.getBrand() + " has more calories than " + b.getBrand();
	}
        if (a.getcalNum() == b.getcalNum()) {
          return a.getBrand() + " & " + b.getBrand() + " have the same numer of calories";
        }
	else {
          return b.getBrand() + " has more calories than " +  a.getBrand();
	}
  }

  public static void main(String[] args) {
    Cereal slay = new Cereal("Corn Pops", 110);
    Cereal barney = new Cereal("Count Chocula", 110);
    Cereal chocolateMilk = new Cereal("Cap'n'Crunch", 120);

	System.out.println(compare(slay, barney));
	System.out.println(compare(chocolateMilk, barney));
  }
}

