package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BerlinClockTimeConverterTest {

    TimeConverter berlinTimeConverter=new BerlinClockTimeConverter();

    @Test
    public void testShouldConvertInputTime(){
        String lineSeparator=System.lineSeparator();
        Assert.assertEquals("Y" +lineSeparator+
                "RROO" +lineSeparator+
                "OOOO" +lineSeparator+
                "YYRYYRYYROO" +lineSeparator+
                "OOOO",berlinTimeConverter.convertTime("10:45:58"));

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testShouldThrowRuntimeExceptionForNegativeTime(){
        exception.expect(RuntimeException.class);
        berlinTimeConverter.convertTime("-10:20:22");
    }

    @Test
    public void testShouldThrowRuntimeExceptionForInvalidTime(){
        exception.expect(RuntimeException.class);
        berlinTimeConverter.convertTime("26:20:22");
    }
}
