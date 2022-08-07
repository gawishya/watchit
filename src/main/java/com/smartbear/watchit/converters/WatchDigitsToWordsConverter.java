package com.smartbear.watchit.converters;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class WatchDigitsToWordsConverter {

    private final Map<Integer, String> lessThanTenMap = Map.of(
            0, "",
            1, "one",
            2, "two",
            3, "three",
            4, "four",
            5, "five",
            6, "six",
            7, "seven",
            8, "eight",
            9, "nine"
    );

    private final Map<Integer, String> lessThanTwentyMap = Map.of(
            10, "ten",
            11, "eleven",
            12, "twelve",
            13, "thirteen",
            14, "fourteen",
            15, "fifteen",
            16, "sixteen",
            17, "seventeen",
            18, "eighteen",
            19, "nineteen"
    );

    private final Map<Integer, String> tenthNumbers = Map.of(
            2, "twenty",
            3, "thirty",
            4, "forty",
            5, "fifty"

    );

    public String convert(Integer number) throws OperationNotSupportedException {

        if (number < 10) {
            return lessThanTenMap.get(number);
        } else if (number < 20) {
            return lessThanTwentyMap.get(number);
        } else if (number < 60) {
            final Character tenths = number.toString().charAt(0);
            final Character units = number.toString().charAt(1);
            if (units == '0') {
                return tenthNumbers.get(Integer.parseInt(String.valueOf(tenths)));
            } else {

                return tenthNumbers.get(Integer.parseInt(String.valueOf(tenths)))
                        .concat(" ")
                        .concat(lessThanTenMap.get(Integer.parseInt(String.valueOf(units))));
            }
        }
        throw new OperationNotSupportedException("Numbers more than Sixty are not supported");
    }
}
