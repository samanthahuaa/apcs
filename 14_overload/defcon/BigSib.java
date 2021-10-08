/*
Frogs on Fire: Andrew Piatetsky, Samantha Hua, and Perry Huang
APCS
HW14 -- Using Different Types of Constructors  
2021-10-07
*/

/*
Discoveries:
If you do not pass any parameters into the constructor (you use a default constructor), you can not customize the constructor's actions.
QCC:
None at the moment.
*/

public class BigSib {
  String boop;
  public BigSib() {
    boop = "Why hello";
  }
  
  public String greet(String a) {
    return boop + " " + a;
  }
}
