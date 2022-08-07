package com.smartbear.watchit.validators;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

public class TimeValidator extends BaseValidator<String> {

    // This regex matches hh:mm & h:mm & 24 hrs system
    private final String HH_MM_OR_H_MM_REGEX = "^(?:(?:[01][0-9]|[0-9])|2[0-3])[-:h][0-5][0-9]$";

    @Override
    protected boolean validate(String time) throws TimeNotValidException {

        final boolean match = Pattern.matches(HH_MM_OR_H_MM_REGEX, time);
        if (!match) {
            throw getError();
        } else {
            return true;
        }
    }

    private TimeNotValidException getError() {

        return new TimeNotValidException("Time does not match a valid pattern, Time must be in this format HH:mm !");
    }

    @RequiredArgsConstructor
    @Getter
    public static class TimeNotValidException extends Exception {

        private final String message;
    }
}
