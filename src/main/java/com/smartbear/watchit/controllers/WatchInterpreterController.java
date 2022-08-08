package com.smartbear.watchit.controllers;

import com.smartbear.watchit.domain.WatchInterpreter;
import com.smartbear.watchit.domain.WatchInterpreterFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/watch")
public class WatchInterpreterController {

    private final WatchInterpreter britishInterpreter = WatchInterpreterFactory.getWatchInterpreter("British");

    /**
     * interpret provides the user with the main functionality that
     * transforms between the numeric time to the spoken form of the
     * desired time
     *
     * @param time String of time in HH:mm format
     * @return String of the spoken form of the time input or the error message
     */
    @GetMapping("interpreter")
    public String interpret(@RequestParam("time") String time) {

        try {

            return britishInterpreter.writeTimeInWords(time);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
