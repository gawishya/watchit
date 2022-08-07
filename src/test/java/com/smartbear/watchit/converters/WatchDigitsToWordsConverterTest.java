package com.smartbear.watchit.converters;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.mockito.MockitoAnnotations.openMocks;

class WatchDigitsToWordsConverterTest {

    private WatchDigitsToWordsConverter subject;

    @BeforeEach
    void init() {

        openMocks(this);
        subject = new WatchDigitsToWordsConverter();
    }

    @Test
    void convert_whenLessThanTen_returnCorrectOneDigitInterpretation() throws OperationNotSupportedException {

        //Given
        final Integer number = 7;

        //When
        final String result = subject.convert(number);

        //Then
        Assertions.assertEquals("seven", result);
    }

    @Test
    void convert_whenLessThanTwenty_returnCorrectOneDigitInterpretation() throws OperationNotSupportedException {
        //Given
        final Integer number = 18;

        //When
        final String result = subject.convert(number);

        //Then
        Assertions.assertEquals("eighteen", result);
    }

    @Test
    void convert_whenLessThanSixty_returnCorrectOneDigitInterpretation() throws OperationNotSupportedException {

        //Given
        final Integer number = 35;

        //When
        final String result = subject.convert(number);

        //Then
        Assertions.assertEquals("thirty five", result);
    }

    @Test
    void convert_whenMoreThanSixty_returnCorrectOneDigitInterpretation() {
        //Given
        final Integer number = 71;

        //When
        final ThrowableAssert.ThrowingCallable callable = () -> subject.convert(number);

        //Then
        Assertions.assertThrows(OperationNotSupportedException.class, callable::call);
    }
}
