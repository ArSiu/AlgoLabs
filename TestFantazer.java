import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFantazer {
    private Fantazer fantazer;
    private String firstBin = "101101101";
    private int firstNum = 5;
    private String firstAns = "[101, 101, 101]";

    private String secondBin = "1111101";
    private int secondNum = 5;
    private String secondAns = "[1111101]";

    private String thirdBin = "110011011";
    private int thirdNum = 5;
    private String thirdAns = "[11001, 101, 1]";

    private String fourthBin = "100111011110100100111110110011100101000111100101110010001100111011110100100111110110011100101000110010110000111100101110010001";
    private int fourthNum = 7;
    private String fourthAns = "[1001110111101001001111101100111001010001, 11100101110010001, 1001110111101001001111101100111001010001, 100101100001, 11100101110010001]";




    @Before
    public void init() {
        fantazer = new Fantazer();
    }

    @Test
    public void testFirst() {
        Assert.assertEquals(firstAns,fantazer.findMinBin(firstBin,firstNum).toString());
    }

    @Test
    public void secondFirst() {
        Assert.assertEquals(secondAns,fantazer.findMinBin(secondBin,secondNum).toString());
    }

    @Test
    public void thirdFirst() {
        Assert.assertEquals(thirdAns,fantazer.findMinBin(thirdBin,thirdNum).toString());
    }

    @Test
    public void fourthFirst() {
        Assert.assertEquals(fourthAns,fantazer.findMinBin(fourthBin,fourthNum).toString());
    }
}
