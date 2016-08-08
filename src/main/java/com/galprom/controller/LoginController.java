package com.galprom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Не правильне ім'я або пароль!");
        }

        if (logout != null) {
            model.addObject("msg", "Ви зайшли в систему успішно.");
        }
        model.setViewName("login");

        return model;
    }
}
