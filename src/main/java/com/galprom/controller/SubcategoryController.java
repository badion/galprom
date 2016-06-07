package com.galprom.controller;

import com.galprom.model.Grid;
import com.galprom.model.SubCategory;
import com.galprom.repository.GridRepository;
import com.galprom.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.util.Collections.sort;

/**
 * Created by Home on 07.06.2016.
 */
@Controller
public class SubcategoryController {

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private SubCategoryRepository subcategoryRepository;

    @RequestMapping(value = "/categories/sub/{categoryId}", method = RequestMethod.GET)
    public ModelAndView getSubcategories(@PathVariable Long categoryId, ModelAndView model) {
        List<SubCategory> grids = subcategoryRepository.findSubcategoriesByCategoryId(categoryId);
        model.addObject("subcategory", grids).setViewName("subcategories");
        return model;
    }
}
