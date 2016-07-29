package sl.paket.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by serglit on 29.07.16.
 */
public class SquareTest {
@Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area2(),25.0);


    }

}
