package com.smartbear.watchit.validators;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.MockitoAnnotations.openMocks;

class TimeValidatorTest {

    private TimeValidator subject;

    @BeforeEach
    void init() {

        openMocks(this);
        subject = new TimeValidator();
    }

    @Test
    public void validate_whenValidTime_returnTrue() throws Exception {

        //Given
        final String time = "13:45";

        //When
        final boolean result = subject.isValid(time);

        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void validate_whenInValidTime_throwTimeNotValidException() {

        //Given
        final String time = "27:45";

        //When
        final ThrowableAssert.ThrowingCallable callable = () -> subject.isValid(time);

        //Then
        assertThrows(TimeValidator.TimeNotValidException.class, callable::call);
    }
}
