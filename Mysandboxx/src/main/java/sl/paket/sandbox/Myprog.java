package sl.paket.sandbox;

public class Myprog {
  public static void main(String[] args) {
  hello("Sergei");

      double a = 6;
      double b = 5;
      System.out.println("Area ="+ area1(a,b));

  }
    public static void hello (String whoUare) {
   System.out.println("Hello," + whoUare+ "!");

 }

    public static double area1 (double a, double b) {
     return a*b;



    }




}