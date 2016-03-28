package com.galprom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Badion on 28.03.2016.
 */

@Controller
public class WelcomePageController {

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        return new ModelAndView("welcome");
    }
}
