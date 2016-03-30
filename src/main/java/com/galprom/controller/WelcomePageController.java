package com.galprom.controller;

import com.galprom.model.Category;
import com.galprom.model.Good;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GoodRepository;
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
    private static final String GOOD = "good";
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GoodRepository goodRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelAndView model) {
        List<Good> goodList = goodRepository.findAll();
        model.addObject(GOOD, goodList);
        System.out.println(goodList);

        List<Category> categories = categoryRepository.findAll();
        model.addObject(CATEGORY, categories);
        System.out.println(categories);
        model.setViewName("categories");
        return model;

    }
}
