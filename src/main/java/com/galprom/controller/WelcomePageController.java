package com.galprom.controller;

import com.galprom.model.Category;
import com.galprom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Badion on 28.03.2016.
 */

@Controller
public class WelcomePageController {

    private static final String CATEGORY = "category";
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelAndView model) {
        List<Category> categories = categoryRepository.findAll();
        model.addObject(CATEGORY, categories);
        System.out.println(categories);
        model.setViewName("categories");
        return model;

    }
}
