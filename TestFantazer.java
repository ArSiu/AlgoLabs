import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFantazer {
    private Fantazer fantazer;
    private final String firstBin = "101101101";
    private final int firstNum = 5;
    private final int firstAns = 3;

    private final String secondBin = "1111101";
    private final int secondNum = 5;
    private final int secondAns = 1;

    private final String thirdBin = "110011011";
    private final int thirdNum = 5;
    private final int thirdAns = 3;

    private final String fourthBin = "111110001101010111100101100001";
    private final int fourthNum = 7;
    private final int fourthAns = 4;

    @Before
    public void init() {
        fantazer = new Fantazer();
    }

    @Test
    public void firstTest() {
        Assert.assertEquals(firstAns,fantazer.findMinBin(firstBin,firstNum));
    }

    @Test
    public void secondTest() {
        Assert.assertEquals(secondAns,fantazer.findMinBin(secondBin,secondNum));
    }

    @Test
    public void thirdTest() {
        Assert.assertEquals(thirdAns,fantazer.findMinBin(thirdBin,thirdNum));
    }

    @Test
    public void fourthTest() {
        Assert.assertEquals(fourthAns,fantazer.findMinBin(fourthBin,fourthNum));
    }

}
