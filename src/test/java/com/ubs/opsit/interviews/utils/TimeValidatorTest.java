package com.ubs.opsit.interviews.utils;

import org.junit.Assert;
import org.junit.Test;

public class TimeValidatorTest {


    @Test
    public void inputTimeShouldbeNumericOnly(){
        Assert.assertTrue(TimeValidator.isInputTimeNumeric(new String[]{"11", "00","22"}));
        Assert.assertFalse(TimeValidator.isInputTimeNumeric(new String[]{"aa", "10","c*"}));
    }
    @Test
    public void inputTimeShouldbeValid(){
        Assert.assertTrue(TimeValidator.isInputTimeValid(00,00,00));
        Assert.assertTrue(TimeValidator.isInputTimeValid(10,02,33));
        Assert.assertTrue(TimeValidator.isInputTimeValid(23,59,59));
        Assert.assertTrue(TimeValidator.isInputTimeValid(24,00,00));
        Assert.assertFalse(TimeValidator.isInputTimeValid(25,00,00));
        Assert.assertFalse(TimeValidator.isInputTimeValid(10,60,00));
        Assert.assertFalse(TimeValidator.isInputTimeValid(10,20,125));
    }

}
