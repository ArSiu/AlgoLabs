import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class TestFantazer {
    private Fantazer fantazer;
    private final String firstBin = "101101101";
    private final int firstNum = 5;
    private final String firstAns = "[101, 101, 101]";

    private final String secondBin = "1111101";
    private final int secondNum = 5;
    private final String secondAns = "[1111101]";

    private final String thirdBin = "110011011";
    private final int thirdNum = 5;
    private final String thirdAns = "[11001, 101, 1]";

    private final String fourthBin = "100111011110100100111110110011100101000111100101110010001100111011110100100111110110011100101000110010110000111100101110010001";
    private final int fourthNum = 7;
    private final String fourthAns = "[1001110111101001001111101100111001010001, 11100101110010001, 1001110111101001001111101100111001010001, 100101100001, 11100101110010001]";




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

    @Test
    public void testFile(){
        try{
            Fantazer fantazer = new Fantazer();
            File testFile = new File(".\\src\\test.txt");
            File resultFile = new File(".\\src\\resultForTest.txt");
            File currentRun = new File(".\\src\\res.txt");

            if(currentRun.exists()){
                Files.delete(currentRun.toPath());
                Files.createFile(currentRun.toPath());
            } else {
                Files.createFile(currentRun.toPath());
            }

            BufferedReader br1 = new BufferedReader(new FileReader(testFile.getPath()));
            BufferedReader br2 = new BufferedReader(new FileReader(currentRun.getPath()));
            BufferedReader br3 = new BufferedReader(new FileReader(resultFile.getPath()));
            String test = br1.readLine();
            String result = br3.readLine();


            long start = System.currentTimeMillis();
            List<String> a = fantazer.findMinBin(test,7);
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            System.out.println(sec + " seconds");

            BufferedWriter bw = new BufferedWriter(new FileWriter(currentRun.getPath()));

            for(String t:a){
                bw.write(t+"|");
            }

            String current = br2.readLine();

            if(current.equals(result)){
                System.out.println("\nOK!!!");
            }else {
                System.out.println("\nBAD!!!");
            }

            br1.close();
            br2.close();
            bw.flush();
            bw.close();
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
