package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.core.BerlinClock;
import com.ubs.opsit.interviews.model.TimeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClockTimeConverter implements TimeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClockTimeConverter.class);


    public String convertTime(String aTime) {
        LOG.info("Converting time for the given string"+ aTime);
        TimeModel time = TimeModel.createTimeInstance(aTime);
        if(null!=time){
            BerlinClock clock= new BerlinClock();
            return clock.displayTime(time);
        }
         throw new RuntimeException("Could not convert the input time using BerlinClockConverter");
    }
}
