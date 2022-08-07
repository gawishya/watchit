package com.smartbear.watchit.domain;

import com.smartbear.watchit.domain.impl.BritishWatchInterpreter;
import com.smartbear.watchit.domain.impl.GermanWatchIInterpreter;

public class WatchInterpreterFactory {

    private WatchInterpreterFactory() {

    }

    public static WatchInterpreter getWatchInterpreter(String interpreter) {

        if (interpreter.equals("British")) {
            return BritishWatchInterpreter.getInstance();
        } else if (interpreter.equals("German")) {
            return new GermanWatchIInterpreter();
        }
        throw new UnsupportedOperationException("Selected Interpreter is not supported");
    }
}
