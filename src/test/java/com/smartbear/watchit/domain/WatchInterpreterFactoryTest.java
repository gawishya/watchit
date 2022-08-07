package com.smartbear.watchit.domain;

import com.smartbear.watchit.domain.impl.BritishWatchInterpreter;
import com.smartbear.watchit.domain.impl.GermanWatchIInterpreter;
import com.smartbear.watchit.fakers.DomainFaker;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.MockitoAnnotations.openMocks;

class WatchInterpreterFactoryTest {

    private DomainFaker faker = new DomainFaker();

    @BeforeEach
    void init() {

        openMocks(this);
    }

    @Test
    void getWatchInterpreter_whenBritishSelected_returnBritishWatchInterpreter() {

        //Given
        final String selectedInterpreter = "British";

        //When
        final WatchInterpreter result = WatchInterpreterFactory.getWatchInterpreter(selectedInterpreter);

        //Then
        Assertions.assertInstanceOf(BritishWatchInterpreter.class, result);
    }

    @Test
    void getWatchInterpreter_whenGermanSelected_returnGermanWatchInterpreter() {

        //Given
        final String selectedInterpreter = "German";

        //When
        final WatchInterpreter result = WatchInterpreterFactory.getWatchInterpreter(selectedInterpreter);

        //Then
        Assertions.assertInstanceOf(GermanWatchIInterpreter.class, result);
    }

    @Test
    void getWatchInterpreter_whenNoInterpreterFound_throwUnsupportedOperationException() {

        //Given
        final String selectedInterpreter = faker.name().name();

        //When
        final ThrowableAssert.ThrowingCallable callable = () -> WatchInterpreterFactory.getWatchInterpreter(selectedInterpreter);

        //Then
        Assertions.assertThrows(UnsupportedOperationException.class, callable::call);
    }
}
