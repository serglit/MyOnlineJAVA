package Assignment2;

/**
 * Created by serglit on 22.07.16.
 */
public class Distance {

    public static void main(String[] args) {
//Создаем екземпляры класса  Point
        Point p1 = new Point(1, 7); //создана точка р1 с координатами х=1, у=7
        Point p2 = new Point(3, 16);//создана точка р2 с координатами х=3, у=16

//вызываем method distance from class Point c двумя параметрами р1 и р2

        System.out.println("Distance between point p1  and point p2  = "+ Point.distance(p1,p2));
    }


}

