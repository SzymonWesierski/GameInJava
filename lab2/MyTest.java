import org.junit.Test;
import org.junit.Assert;


public class MyTest {

    @Test
    public void zad2Test() {
        Assert.assertEquals(zad2.palindrome("oko"), true);
        Assert.assertEquals(zad2.palindrome("kajak"), true);
        Assert.assertEquals(zad2.palindrome("java"), false);
    }

    @Test
    public void zad3_1Test() {
        Assert.assertEquals(zad3.checkBin("010101001"), true);
        Assert.assertEquals(zad3.checkBin("a10101001"), false);
        Assert.assertEquals(zad3.checkBin("?10101001"), false);
    }

    @Test
    public void zad3_2Test() {
        Assert.assertEquals(zad3.numberZero("010101001"), 5);
    }

    @Test
    public void zad3_3Test() {
        Assert.assertEquals(zad3.numberOne("010101001"), 4);
    }

    @Test
    public void zad3_4Test() {
        Assert.assertEquals(zad3.theSameNumberBin("010101001"), false);
        Assert.assertEquals(zad3.theSameNumberBin("01010011"), true);
    }

}