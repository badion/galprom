package com.galprom.controller;

import com.galprom.model.Category;
import com.galprom.model.Grid;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GridRepository;
import com.galprom.validator.GridValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GridController {

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GridValidator gridValidator;

    @RequestMapping(value = "/categories/grid", method = RequestMethod.GET)
    public ModelAndView getAllGrids(ModelAndView model) {
        model.addObject("grids", gridRepository.findAll()).setViewName("grids");
        return model;
    }


    @RequestMapping(value = { "/categories/newGrid" }, method = RequestMethod.GET)
    public String newGrid(ModelMap model) {
        Grid grid = new Grid();
        model.addAttribute("grid", grid);
        model.addAttribute("edit", false);
        return "grid_new";
    }


    @RequestMapping(value = { "/categories/newGrid" }, method = RequestMethod.POST)
    public String newGridAction(@Valid Grid grid, BindingResult result,
                           ModelMap model) {
        gridValidator.validate(grid, result);
        if (result.hasErrors()) {
            return "grid_new";
        }
        gridRepository.save(grid);
        model.addAttribute("success", "Сітка " + grid.getName() + " " + " додана успішно");
        return "grid_new_succesful";
    }
}
