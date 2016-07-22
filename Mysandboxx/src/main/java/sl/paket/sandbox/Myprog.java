package sl.paket.sandbox;

public class Myprog {
  public static void main(String[] args) {
  hello("Sergei");

      Square s= new Square(7);

      Rectangle r = new Rectangle(6,7);

      System.out.println("Area rectangle ="+ r.area1());
      System.out.println("Area square ="+ s.area2());

  }
    public static void hello (String whoUare) {
   System.out.println("Hello," + whoUare+ "!");

 }







}