/*
Frogs on Fire: Andrew Piatetsky, Samantha Hua, and Perry Huang
APCS
HW14 -- Using Different Types of Constructors 
2021-10-07
*/

/*
Discoveries:
When you assign a instance variable a value when you can call it later and it will retain the same value 
QCC:
Instead of printing "null" when a variable that hasn't been assigned a value is called, is there a way for it to print nothing at all? 
*/

public class BigSib {
  String boop;
  public BigSib(String a) {
    boop = a;
  }
  
  public String greet(String b) {
    return boop + " " + b;
  }
}
