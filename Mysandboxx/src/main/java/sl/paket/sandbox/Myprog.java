package sl.paket.sandbox;

public class Myprog {
  public static void main(String[] args) {
  hello("Sergei");

      Square s= new Square(7);

      Rectangle r = new Rectangle(6,7);

      System.out.println("Area rectangle ="+ area1(r));
      System.out.println("Area square ="+ area2(s));

  }
    public static void hello (String whoUare) {
   System.out.println("Hello," + whoUare+ "!");

 }

    public static double area1 (Rectangle r) {
        return r.a * r.b;
    }
    public static double area2 (Square s) {
        return s.l*s.l;

    }




}