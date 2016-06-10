package com.galprom.controller;

import com.galprom.model.User;
import com.galprom.repository.UserRepository;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Home on 10.06.2016.
 */

@Controller
public class LoginController {
    @Autowired
    private UserRepository loginDelegate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("login");
        User user = new User();
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("categories");
        HttpSession session = request.getSession();
        session.invalidate();
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") User loginBean) {
        ModelAndView model = null;
        try {
            User isValidUser = loginDelegate.findUserByUserNameAndPassword(loginBean.getUsername(), loginBean.getPassword());
            if (isValidUser != null) {
                System.out.println("User Login Successful");
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", isValidUser.getUsername());
                model = new ModelAndView("categories");
            } else {
                model = new ModelAndView("login");
                model.addObject("user", loginBean);
                request.setAttribute("message", "Invalid credentials!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
