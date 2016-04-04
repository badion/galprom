package com.galprom.controller;

import com.galprom.model.Category;
import com.galprom.model.Grid;
import com.galprom.model.Torsion;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GridRepository;
import com.galprom.repository.TorsionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    private static final String CATEGORY = "category";
    private static final String GRID = "grids";
    private static final String TORSION = "torsions";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private TorsionRepository torsionRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllCategories(ModelAndView model) {

        List<Category> categories = categoryRepository.findAll();
        model.addObject(CATEGORY, categories);
        model.setViewName("categories");

        List<Grid> grids = gridRepository.findAll();
        model.addObject(GRID, grids);

        List<Torsion> torsions = torsionRepository.findAll();
        model.addObject(TORSION, torsions);

        return model;
    }

}
