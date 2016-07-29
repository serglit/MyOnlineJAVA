package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by serglit on 29.07.16.
 */
public class PointTest {
@Test
    public void correctDistance() {
    Point p1 = new Point(1, 7); //создана точка р1 с координатами х=1, у=7
    Point p2 = new Point(3, 16);//создана точка р2 с координатами х=3, у=16
    Assert.assertEquals(Point.distance(p1, p2), 9.219544457292887);
}
    @Test
    public void correctDistance2() {
        Point p1 = new Point(3, 4); //создана точка р1 с координатами х=3, у=4
        Point p2 = new Point(7, 22);//создана точка р2 с координатами х=7, у=22
        Assert.assertEquals(Point.distance(p1, p2), 18.439088914585774);
    }

}
