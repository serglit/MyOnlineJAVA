package sl.paket.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by serglit on 05.08.16.
 */
public class TestPrimes {
   @Test
    public void primeTest(){
       Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
   }

    @Test (enabled = false)
    public void primeTestLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }


    @Test
    public void primeNonTest(){
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }
}
