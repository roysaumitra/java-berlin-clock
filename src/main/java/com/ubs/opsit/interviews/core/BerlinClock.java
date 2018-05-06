package com.ubs.opsit.interviews.core;

import com.ubs.opsit.interviews.model.TimeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock {
    private static final int TOTAL_LAMPS_IN_FIRST_ROW = 4;
    private static final int TOTAL_LAMPS_IN_SECOND_ROW = 4;
    private static final int TOTAL_LAMPS_IN_THIRD_ROW = 11;
    private static final int TOTAL_LAMPS_IN_FOURTH_ROW = 4;

    private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);

    public String displayTime(TimeModel time) {
        LOG.info("Displaying time in Berlin clock for", time.getHours()+":"+time.getMins()+":"+time.getSeconds());
        int hours=time.getHours();
        int mins=time.getMins();
        int seconds=time.getSeconds();
        StringBuffer result = new StringBuffer();
        String lineSeparator = System.lineSeparator();
        return result.append(blinkSecondsLamp(seconds)).append(lineSeparator)
                .append(displayHoursTopRow(hours)).append(lineSeparator)
                .append(displayHoursBottomRow(hours)).append(lineSeparator)
                .append(displayMinsTopRow(mins)).append(lineSeparator)
                .append(displayMinsBottomRow(mins)).toString();
    }

    public String blinkSecondsLamp(int seconds) {
        if (seconds % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }

    public String displayHoursTopRow(int hours) {
        return formatLamps(TOTAL_LAMPS_IN_FIRST_ROW, getNoOfLampsThatGlowInTopRow(hours), "R");
    }


    public String displayHoursBottomRow(int hours) {
        return formatLamps(TOTAL_LAMPS_IN_SECOND_ROW, getNoOfLampsThatGlowInBottomRow(hours), "R");
    }

    public String displayMinsTopRow(int mins) {
        String formattedMinsLamp=formatLamps(TOTAL_LAMPS_IN_THIRD_ROW, getNoOfLampsThatGlowInTopRow(mins), "Y");
        return displayQuarterlyMinsInRed(formattedMinsLamp);
    }

    public String displayQuarterlyMinsInRed(String formattedMinsLamp){
        return formattedMinsLamp.replaceAll("YYY","YYR");
    }

    public String displayMinsBottomRow(int mins) {
        return formatLamps(TOTAL_LAMPS_IN_FOURTH_ROW, getNoOfLampsThatGlowInBottomRow(mins), "Y");
    }

    private String formatLamps(int totalLamps, int lampsThatGlow, String displayValue) {
        String formattedResult = "";
        for (int i = 0; i < lampsThatGlow; i++) {
            formattedResult += displayValue;
        }

        int lampsThatDontGlow = totalLamps - lampsThatGlow;
        for (int i = 0; i < lampsThatDontGlow; i++) {
            formattedResult += "O";
        }
        return formattedResult;
    }

    public int getNoOfLampsThatGlowInTopRow(int value) {
        return (value - (value % 5)) / 5;
    }


    public int getNoOfLampsThatGlowInBottomRow(int value) {
        return value % 5 ;
    }


}
