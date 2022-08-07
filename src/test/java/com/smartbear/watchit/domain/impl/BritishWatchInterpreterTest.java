package com.smartbear.watchit.domain.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.MockitoAnnotations.openMocks;

class BritishWatchInterpreterTest {

    private BritishWatchInterpreter subject;

    @BeforeEach
    void init() {

        openMocks(this);
        subject = BritishWatchInterpreter.getInstance();
    }

    @Test
    void writeTimeInWords_whenHoursOnly_returnHourOclock() throws Exception {

        //Given
        final String time = "01:00";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("one o'clock", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenHourIs12_returnNoon() throws Exception {

        //Given
        final String time = "12:00";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("noon", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenHourIsZeroAndMinIsZero_returnMidnigh() throws Exception {

        //Given
        final String time = "00:00";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("midnight", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenHoursMoreThan12_returnHourOclock() throws Exception {

        //Given
        final String time = "22:00";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("ten o'clock", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenMinsLessThanThirty_returnMinsPastHour() throws Exception {

        //Given
        final String time = "05:18";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("eighteen past five", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenMinsLessThanThirtyFive_returnHourThenMins() throws Exception {

        //Given
        final String time = "08:34";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("eight thirty four", interpretedTime);
    }

    @Test
    void writeTimeInWords_whenMinsMoreThanThirtyFive_returnMinsToHour() throws Exception {

        //Given
        final String time = "23:38";

        //When
        final String interpretedTime = subject.writeTimeInWords(time);

        //Then
        Assertions.assertEquals("twenty two to twelve", interpretedTime);
    }

    @Test
    void writeTimeInWords_exampleTestCases() throws Exception {

        //Given
        final Map<String, String> exampleResults = new HashMap<>();
        exampleResults.put("1:00", "one o'clock");
        exampleResults.put("02:05", "five past two");
        exampleResults.put("03:10", "ten past three");
        exampleResults.put("04:15", "quarter past four");
        exampleResults.put("05:20", "twenty past five");
        exampleResults.put("06:25", "twenty five past six");
        exampleResults.put("07:30", "half past seven");
        exampleResults.put("06:32", "six thirty two");
        exampleResults.put("07:35", "twenty five to eight");
        exampleResults.put("08:40", "twenty to nine");
        exampleResults.put("09:45", "quarter to ten");
        exampleResults.put("10:50", "ten to eleven");
        exampleResults.put("11:55", "five to twelve");
        exampleResults.put("00:00", "midnight");
        exampleResults.put("12:00", "noon");

        for (String watchTime :
                exampleResults.keySet()) {
            //When
            final String interpretedTime = subject.writeTimeInWords(watchTime);

            //Then
            Assertions.assertEquals(exampleResults.get(watchTime), interpretedTime);
        }
    }
}
