package com.smartbear.watchit.domain;

import com.smartbear.watchit.domain.impl.BritishWatchInterpreter;
import com.smartbear.watchit.domain.impl.GermanWatchIInterpreter;

public class WatchInterpreterFactory {

    private WatchInterpreterFactory() {

    }

    /**
     * getWatchInterpreter a factory method to provide the user with
     * the correct Interpreter required.
     *
     * @param interpreter String of the required interpreter British/German/..
     * @return One of the concrete classes Implementing WatchInterpreter according
     * to user input.
     */
    public static WatchInterpreter getWatchInterpreter(String interpreter) {

        if (interpreter.equals("British")) {
            return BritishWatchInterpreter.getInstance();
        } else if (interpreter.equals("German")) {
            return new GermanWatchIInterpreter();
        }
        throw new UnsupportedOperationException("Selected Interpreter is not supported");
    }
}
