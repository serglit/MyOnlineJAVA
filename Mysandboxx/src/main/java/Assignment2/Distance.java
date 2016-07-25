package Assignment2;

/**
 * Created by serglit on 22.07.16.
 */
public class Distance {

    public static void main(String[] args) {
//Создаем екземпляры класса  Point
        Point p1 = new Point(1, 7); //создана точка р1 с координатами х=1, у=7
        Point p2 = new Point(3, 16);//создана точка р2 с координатами х=3, у=16
//вызываем функцию distance c двумя параметрами р1 и р2
        distance(p1, p2);
        System.out.println("Distance between point p1  and point p2  = "+ distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {

       // double a = p2.x-p1.x; Math.pow (double а,double х) - возведение числа а в степень х)
      //   double b = p2.y-p1.y; Math.sqrt - извлечение квадратного корня

        return Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));

    }
}

