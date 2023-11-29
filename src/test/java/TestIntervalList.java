import mbti.coding.models.Interval;
import mbti.coding.models.IntervalList;
import org.junit.Assert;
import org.junit.Test;

public class TestIntervalList {
    @Test
    public void testIntervalListMergeMethodBasicExample(){
        IntervalList intervalList = new IntervalList();
        intervalList.add(new Interval(25,30));
        intervalList.add(new Interval(2,19));
        intervalList.add(new Interval(14, 23));
        intervalList.add(new Interval(4,8));
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        expectedResult.add(new Interval(2,23));
        expectedResult.add(new Interval(25, 30));
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testIntervalListMergeMethodExampleNegativeNumbers(){
        IntervalList intervalList = new IntervalList();
        intervalList.add(new Interval(-10,-5));
        intervalList.add(new Interval(-6,-3));
        intervalList.add(new Interval(-15, -12));
        intervalList.add(new Interval(-1,0));
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        expectedResult.add(new Interval(-15,-12));
        expectedResult.add(new Interval(-10, -3));
        expectedResult.add(new Interval(-1,0));
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testIntervalListMergeMethodBiggerDataSetPositiveAndNegativeNumbers(){
        IntervalList intervalList = new IntervalList();
        intervalList.add(new Interval(30,15));
        intervalList.add(new Interval(-6,-3));
        intervalList.add(new Interval(100, 121));
        intervalList.add(new Interval(-1,0));
        intervalList.add(new Interval(119, 156));
        intervalList.add(new Interval(1,19));
        intervalList.add(new Interval(2,4));
        intervalList.add(new Interval(6,34));
        intervalList.add(new Interval(35, 64));
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        expectedResult.add(new Interval(-6,-3));
        expectedResult.add(new Interval(-1, 0));
        expectedResult.add(new Interval(1,34));
        expectedResult.add(new Interval(35,64));
        expectedResult.add(new Interval(100,156));
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testIntervalListMergeMethodOverlappingAgainAndAgain(){
        IntervalList intervalList = new IntervalList();
        intervalList.add(new Interval(1,100));
        intervalList.add(new Interval(99,101));
        intervalList.add(new Interval(100, 102));
        intervalList.add(new Interval(101,103));
        intervalList.add(new Interval(102,104));
        intervalList.add(new Interval(103,105));
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        expectedResult.add(new Interval(1,105));
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testIntervalListMergeMethodEmptyList(){
        IntervalList intervalList = new IntervalList();
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testIntervalListMergeMethodOneElementInList(){
        IntervalList intervalList = new IntervalList();
        intervalList.add(new Interval(1,2));
        IntervalList result = intervalList.merge();

        IntervalList expectedResult = new IntervalList();
        expectedResult.add(new Interval(1,2));
        Assert.assertEquals(result, expectedResult);
    }
}
