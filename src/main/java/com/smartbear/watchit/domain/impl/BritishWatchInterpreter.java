package com.smartbear.watchit.domain.impl;

import com.smartbear.watchit.converters.WatchDigitsToWordsConverter;
import com.smartbear.watchit.domain.WatchInterpreter;
import com.smartbear.watchit.validators.TimeValidator;

import javax.naming.OperationNotSupportedException;

public class BritishWatchInterpreter implements WatchInterpreter {

    public static final String HOUR_DELIMITER = ":";

    public static final int MINS_IN_HOUR = 60;

    private static BritishWatchInterpreter instance;

    private TimeValidator timeValidator;

    private WatchDigitsToWordsConverter converter;

    private BritishWatchInterpreter() {

        timeValidator = new TimeValidator();
        converter = new WatchDigitsToWordsConverter();
    }

    @Override
    public String writeTimeInWords(String time) throws Exception {

        timeValidator.isValid(time);
        int hrs = Integer.parseInt(time.split(HOUR_DELIMITER)[0]);
        final int mins = Integer.parseInt(time.split(HOUR_DELIMITER)[1]);

        if (hrs > 12) {
            hrs = hrs - 12;
        }

        if (mins == 0) {
            return handleHoursOnly(hrs);
        }

        return handleHrsAndMins(hrs, mins);
    }

    private String handleHrsAndMins(int hrs, int mins) throws OperationNotSupportedException {

        final String minsInWords = converter.convert(mins);
        final String nextHourInWords = converter.convert(hrs == 12 ? 1 : hrs + 1);
        final int hoursAfterFix = hrs == 0 ? 12 : hrs;
        final String hoursAfterFixInWords = converter.convert(hoursAfterFix);
        if (mins == 15) {
            return "quarter past ".concat(hoursAfterFixInWords);
        }
        if (mins < 30) {
            return minsInWords
                    .concat(" past ")
                    .concat(hoursAfterFixInWords);
        } else if (mins == 30) {
            return "half"
                    .concat(" past ")
                    .concat(hoursAfterFixInWords);
        } else if (mins < 35) {
            return hoursAfterFixInWords
                    .concat(" ")
                    .concat(minsInWords);
        } else if (mins == 45) {
            return "quarter to "
                    .concat(nextHourInWords);
        } else {
            final Integer minsRemainingToHour = MINS_IN_HOUR - mins;
            final String minsRemainingInWords = converter.convert(minsRemainingToHour);

            return minsRemainingInWords
                    .concat(" to ")
                    .concat(nextHourInWords);
        }
    }

    private String handleHoursOnly(int hrs) throws OperationNotSupportedException {

        if (hrs == 12) {
            return "noon";
        }

        if (hrs == 0) {
            return "midnight";
        }

        final String hrsInWords = converter.convert(hrs);

        return hrsInWords.concat(" o'clock");
    }

    public static synchronized BritishWatchInterpreter getInstance() {

        if (instance == null) {
            instance = new BritishWatchInterpreter();
        }
        return instance;
    }
}
