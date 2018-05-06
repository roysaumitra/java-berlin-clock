package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.utils.TimeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeModel {

    private static final Logger LOG = LoggerFactory.getLogger(TimeModel.class);

    private int hours;
    private int mins;
    private int seconds;

    public int getHours() {
        return hours;
    }


    public int getMins() {
        return mins;
    }


    public int getSeconds() {
        return seconds;
    }


    private TimeModel(int hours, int mins, int seconds) {
        this.hours = hours;
        this.mins = mins;
        this.seconds = seconds;
    }


    public static TimeModel createTimeInstance(String aTime) {

        if (null != aTime && !aTime.isEmpty()) {
            LOG.info("Creating TimeModel Instance for "+aTime);
            String[] timeInStrArr = aTime.split(":");
            if (TimeValidator.isInputTimeNumeric(timeInStrArr)) {
                int hours = Integer.parseInt(timeInStrArr[0]);
                int mins = Integer.parseInt(timeInStrArr[1]);
                int seconds = Integer.parseInt(timeInStrArr[2]);
                if (timeInStrArr.length == 3 && TimeValidator.isInputTimeValid(hours, mins, seconds)) {
                    return new TimeModel(hours, mins, seconds);

                }
            }
        }
        return null;
    }

}
