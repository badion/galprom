package com.galprom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Home on 12.06.2016.
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Немає доступу до цієї сторінки!");
        } else {
            model.addObject("msg", "Немає доступу до цієї сторінки!");
        }
        model.setViewName("error");
        return model;
    }
}
