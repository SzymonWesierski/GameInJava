import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MyTest {

    @Test
    public void zad2Test() {
        assertTrue(zad2.palindrome("oko"));
        assertTrue(zad2.palindrome("kajak"));
        assertFalse(zad2.palindrome("java"));
    }

    @Test
    public void checkBinTest() {
        assertTrue(zad3.checkBin("010101001"));
        assertFalse(zad3.checkBin("a10101001"));
        assertFalse(zad3.checkBin("?10101001"));
    }

    @Test
    public void numberZeroTest() {
        Assert.assertEquals(zad3.numberZero("010101001"), 5);
    }

    @Test
    public void numberOne3Test() {
        Assert.assertEquals(zad3.numberOne("010101001"), 4);
    }

    @Test
    public void theSameNumberBinTest() {
        assertFalse(zad3.theSameNumberBin("010101001"));
        assertTrue(zad3.theSameNumberBin("01010011"));
    }

    @Test
    public void generatorTest() {
        Assert.assertEquals(zad4.generator(8,1,2).length,8);
        Assert.assertEquals(zad4.generator(2,1,2).length,2);
        Assert.assertEquals(zad4.generator(14,1,2).length,14);

        int [] tablica;
        boolean check = false;
        tablica = zad4.generator(5,2,10);
        for (int j : tablica) {
            if (j > 10) {
                check = false;
            } else check = j >= 2;
        }
        assertTrue(check);
    }

    @Test
    public void encryptTest()
    {
        Assert.assertEquals(zad5.array('C','X'),'Z');
        Assert.assertEquals(zad5.array('Z','K'),'J');
        Assert.assertEquals(zad5.array('Z','Q'),'P');
        Assert.assertEquals(zad5.fixingKey("ZASZYFRUJ MNIE","KATAR"),"KATARKATARKAT");
        Assert.assertEquals(zad5.fixingText("ZASZYFRUJ MNIE"),"ZASZYFRUJMNIE");
        Assert.assertEquals(zad5.encrypt("ZASZYFRUJ MNIE","KATAR"),"JALZPPRNJDXIX");
    }

}