package test;

import com.arsiu.RabinKarp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RabinKarpTest {
    private RabinKarp rabinKarp;

    @Before
    public void init() {
        rabinKarp = new RabinKarp();
    }

    @Test
    public void firstTest() {
        rabinKarp.search("ejrwkejrwkeqjrowjerowjerwo213erow123pejrwoeqrk","erow");
        Assert.assertEquals("[17, 29]",rabinKarp.getMatches().toString());
    }

    @Test
    public void secondTest() {
        rabinKarp.search("AAAA","A");
        Assert.assertEquals("[0, 1, 2, 3]",rabinKarp.getMatches().toString());
    }

    @Test
    public void thirdTest() {
        rabinKarp.search("AE2A#E2#EA2#1EA","EA2#");
        Assert.assertEquals("[8]",rabinKarp.getMatches().toString());
    }
}
