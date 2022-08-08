package com.smartbear.watchit.domain.impl;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.openMocks;

class GermanWatchIInterpreterTest {

    private GermanWatchIInterpreter subject;

    @BeforeEach
    void init() {

        openMocks(this);
        subject = new GermanWatchIInterpreter();
    }

    @Test
    void writeTimeInWords_always_throwUnsupportedOperationException() {

        // When
        final ThrowableAssert.ThrowingCallable callable = () -> subject.writeTimeInWords(anyString());

        // Then
        Assertions.assertThrows(UnsupportedOperationException.class, callable::call);
    }
}
