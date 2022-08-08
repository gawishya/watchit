package com.smartbear.watchit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    /**
     * This is the entrypoint to the application,
     * From which the user can interact & send requests to the application
     *
     * @return ModelAndView object with the view as the index page
     */
    @GetMapping("/")
    public ModelAndView indexPage() {

        return new ModelAndView("index");
    }
}
