package Assignments;

/**
 * Created by serglit on 23.07.16.
 */
public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {

        // double a = p2.x-p1.x; Math.pow (double а,double х) - возведение числа а в степень х)
        //   double b = p2.y-p1.y; Math.sqrt - извлечение квадратного корня

        return Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));

    }
    }
