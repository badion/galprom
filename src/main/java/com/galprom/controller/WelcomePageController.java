package com.galprom.controller;

import com.galprom.model.Category;
import com.galprom.model.Greed;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WelcomePageController {

    private static final String CATEGORY = "category";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GreedRepository greedRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelAndView model) {
        List<Category> categories = categoryRepository.findAll();
        System.out.println(categories);

        List<Greed> greedList = greedRepository.findAll();
        System.out.println(greedList);

        model.addObject(CATEGORY, categories);

        model.setViewName("categories");
        return model;

    }
}
