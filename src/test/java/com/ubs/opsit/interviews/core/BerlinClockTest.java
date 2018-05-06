package com.ubs.opsit.interviews.core;

import com.ubs.opsit.interviews.model.TimeModel;
import org.junit.Assert;
import org.junit.Test;


public class BerlinClockTest {

    private BerlinClock clock = new BerlinClock();


    @Test
    public void testYellowLampShouldBlinkOnlyForEvenSeconds() {
        Assert.assertEquals("Y", clock.blinkSecondsLamp(2));
        Assert.assertEquals("O", clock.blinkSecondsLamp(11));
        Assert.assertEquals("Y", clock.blinkSecondsLamp(18));
    }

    @Test
    public void testNoOfLampsThatShouldGlowInTopRows() {
        Assert.assertEquals(0, clock.getNoOfLampsThatGlowInTopRow(4));
        Assert.assertEquals(1, clock.getNoOfLampsThatGlowInTopRow(6));
        Assert.assertEquals(2, clock.getNoOfLampsThatGlowInTopRow(11));
        Assert.assertEquals(3, clock.getNoOfLampsThatGlowInTopRow(18));
    }

    @Test
    public void testNoOfLampsThatShouldGlowInBottomRows() {
        Assert.assertEquals(0, clock.getNoOfLampsThatGlowInBottomRow(5));
        Assert.assertEquals(3, clock.getNoOfLampsThatGlowInBottomRow(8));
        Assert.assertEquals(2, clock.getNoOfLampsThatGlowInBottomRow(37));
        Assert.assertEquals(4, clock.getNoOfLampsThatGlowInBottomRow(59));
    }


    @Test
    public void testHoursTopRowShouldGlowRedEvery5Hours() {
        Assert.assertEquals("OOOO", clock.displayHoursTopRow(0));
        Assert.assertEquals("ROOO", clock.displayHoursTopRow(5));
        Assert.assertEquals("RROO", clock.displayHoursTopRow(11));
        Assert.assertEquals("RRRO", clock.displayHoursTopRow(17));
        Assert.assertEquals("RRRR", clock.displayHoursTopRow(24));
    }


    @Test
    public void testHoursBottomRowShouldGlowRedForRemainderFromRowAbove() {
        Assert.assertEquals("OOOO", clock.displayHoursBottomRow(0));
        Assert.assertEquals("OOOO", clock.displayHoursBottomRow(5));
        Assert.assertEquals("ROOO", clock.displayHoursBottomRow(11));
        Assert.assertEquals("RROO", clock.displayHoursBottomRow(17));
        Assert.assertEquals("RRRO", clock.displayHoursBottomRow(23));
        Assert.assertEquals("RRRR", clock.displayHoursBottomRow(24));
    }

    @Test
    public void testMinsTopRowShouldGlowYellowEvery5MinsAndRedEveryQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", clock.displayMinsTopRow(0));
        Assert.assertEquals("YOOOOOOOOOO", clock.displayMinsTopRow(5));
        Assert.assertEquals("YYROOOOOOOO", clock.displayMinsTopRow(15));
        Assert.assertEquals("YYRYYRYYROO", clock.displayMinsTopRow(49));
    }

    @Test
    public void testMinsBottomRowShouldGlowYellowForRemainderFromRowAbove() {
        Assert.assertEquals("YOOO", clock.displayMinsBottomRow(1));
        Assert.assertEquals("YYYO", clock.displayMinsBottomRow(3));
        Assert.assertEquals("YYYY", clock.displayMinsBottomRow(4));

    }

    @Test
    public void testQuarterlyMinsLampShouldGlowRed() {
        Assert.assertEquals("YYR", clock.displayQuarterlyMinsInRed("YYY"));
    }


    @Test
    public void testDisplayTimeInBerlinClock() {
        TimeModel time=TimeModel.createTimeInstance("13:48:20");
        String result=clock.displayTime(time);
        String resultArr[]=result.split(System.lineSeparator());
        Assert.assertEquals("Y",resultArr[0]);
        Assert.assertEquals("RROO",resultArr[1]);
        Assert.assertEquals("RRRO",resultArr[2]);
        Assert.assertEquals("YYRYYRYYROO",resultArr[3]);
        Assert.assertEquals("YYYO",resultArr[4]);

    }


}
