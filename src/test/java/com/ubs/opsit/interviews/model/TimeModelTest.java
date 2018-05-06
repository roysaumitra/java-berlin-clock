package com.ubs.opsit.interviews.model;


import org.junit.Assert;
import org.junit.Test;

public class TimeModelTest {

    @Test
    public void testIfValidTimeModelInstanceIsCreated() {
        Assert.assertNotNull("Valid TimeModel instance should be created", TimeModel.createTimeInstance("13:00:12"));
        Assert.assertNotNull("Valid TimeModel instance should be created for midnight", TimeModel.createTimeInstance("00:00:00"));
        Assert.assertNotNull("Valid TimeModel instance should be created for midnight special case", TimeModel.createTimeInstance("24:00:00"));
        Assert.assertNull("Should not  instantiate a negative TimeModel", TimeModel.createTimeInstance("-10:00:12"));
        Assert.assertNull("Should not instantiate a TimeModel with mins=60", TimeModel.createTimeInstance("12:60:00"));
        Assert.assertNull("Should not instantiate a TimeModel with secs=61", TimeModel.createTimeInstance("23:59:61"));
        Assert.assertNull("Should not instantiate a TimeModel with milliseconds", TimeModel.createTimeInstance("12:22:40:44"));
    }


}
