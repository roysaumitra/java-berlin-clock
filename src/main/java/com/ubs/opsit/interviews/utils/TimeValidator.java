package com.ubs.opsit.interviews.utils;


public class TimeValidator {


    public static boolean isInputTimeValid(int hours, int mins, int seconds) {
        return hours >= 0 && (isMidnightSpecialCase(hours, mins, seconds) || hours <= 23)
                && mins >= 0 && mins <= 59
                && seconds >= 0 && seconds <= 59;

    }

    private static boolean isMidnightSpecialCase(int hours, int mins, int seconds) {
        return hours == 24 && mins == 0 && seconds == 0;
    }

    public static boolean isInputTimeNumeric(String[] array) {
        String pattern="[0-9]+";
        return array[0].matches((pattern))
                && array[1].matches((pattern))
                && array[2].matches((pattern));
    }
}
