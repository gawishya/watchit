package com.smartbear.watchit.domain;

public interface WatchInterpreter {

    /**
     * writeTimeInWords provides a functionality of converting
     * time written in numbers to time written in spoken form
     * ex: half past ten for 10:30
     *
     * @param timeInNumbers time written in numeric way 10:30
     * @return String of time written in the spoken form
     * @throws Exception
     */
    String writeTimeInWords(String timeInNumbers) throws Exception;
}
