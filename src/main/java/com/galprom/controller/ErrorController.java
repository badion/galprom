package com.galprom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

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

    @RequestMapping(value="/404")
    public ModelAndView error404(){
        ModelAndView m = new ModelAndView();
        System.out.println("custom error handler");
        m.setViewName("404");
        return m;
    }

}
