package com.galprom.controller;

import com.galprom.exceptions.PageNotFoundException;
import com.galprom.model.User;
import com.galprom.repository.UserRepository;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Home on 10.06.2016.
 */

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
