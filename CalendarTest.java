import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CalendarTest {
    private Calendar calendar;
    private final ArrayList<Tuple> testArrOneInput = new ArrayList<>(Arrays.asList(
            new Tuple(0,1),
            new Tuple(3,5),
            new Tuple(4,8),
            new Tuple(10,12),
            new Tuple(9,10)));
    private final ArrayList<Tuple> testArrOneOutput = new ArrayList<>(Arrays.asList(
            new Tuple(0,1),
            new Tuple(3,8),
            new Tuple(9,12)));

    private boolean isArraysEquals(ArrayList<Tuple> arr1, ArrayList<Tuple> arr2) {
        for (int i = 0; i < arr1.size();i++){
            if(arr1.get(i).getStart() != arr2.get(i).getStart() || arr1.get(i).getEnd() != arr2.get(i).getEnd()){
                return false;
            }
        }
        return true;
    }

    @Before
    public void init() {
        calendar = new Calendar();
    }

    @Test
    public void testIsArraysEquals() {
        Assert.assertTrue(isArraysEquals(testArrOneOutput,testArrOneOutput));
    }


    @Test
    public void testOne() {
        calendar.setTupleArr(testArrOneInput);
        calendar.mergeRanges();
        Assert.assertTrue(isArraysEquals(calendar.getMergeRange(),testArrOneOutput));
    }


}
