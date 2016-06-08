package com.galprom.controller;

import com.galprom.model.Grid;
import com.galprom.model.Product;
import com.galprom.model.SubCategory;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GridRepository;
import com.galprom.repository.ProductRepository;
import com.galprom.repository.SubCategoryRepository;
import com.galprom.service.GridServiceImpl;
import com.galprom.validator.GridValidator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class GridController {

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private GridValidator gridValidator;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GridServiceImpl gridService;


    @RequestMapping(value = "/categories/grid", method = RequestMethod.GET)
    public ModelAndView getAllGrids(ModelAndView model) {
        Map<SubCategory, List<Grid>> gridPage = new HashMap<>();

        categoryRepository.findAll()
                .stream()
                .filter(category -> category.getLink().equals("grid"))
                .collect(Collectors.toList())
                .get(0)
                .getSubCategories()
                .forEach(subCategory -> gridPage
                .put(subCategory,subCategory.getProducts()
                        .stream()
                        .map(product -> (Grid)product)
                        .collect(Collectors.toList())));
        model.addObject("gridPage", gridPage).setViewName("grids");
        return model;
    }

    @RequestMapping(value = {"/categories/newGrid"}, method = RequestMethod.GET)
    public String newGrid(ModelMap model) {
        Grid grid = new Grid();
        model.addAttribute("grid", grid);
        model.addAttribute("edit", false);
        return "grid_new";
    }

    @RequestMapping(value = {"/categories/newGrid"}, method = RequestMethod.POST)
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

    @RequestMapping(value = "/categories/grid/{id}", method = RequestMethod.POST)
    public String deleteGrid(@PathVariable("id") Long id) {
        Grid grid = gridRepository.findOne(id);
        if (grid != null) {
            Hibernate.initialize(grid);
            gridRepository.delete(grid);
        }
        return "redirect:/categories/grid";
    }

    @RequestMapping(value = "/categories/grid/edit/{id}", method = RequestMethod.GET)
    public String editGrid(@PathVariable("id") Long id, ModelMap model) {
        Grid grid = gridRepository.findOne(id);
        model.addAttribute("grid", grid);
        model.addAttribute("edit", true);
        return "grid_new";
    }

    @RequestMapping(value = "/categories/grid/edit/{id}", method = RequestMethod.POST)
    public String editGridAction(@Valid Grid grid, BindingResult result,
                                 ModelMap model) {
        gridValidator.validate(grid, result);
        if (result.hasErrors()) {
            return "grid_new";
        }
        gridRepository.save(grid);
//        model.addAttribute("success");
        return "redirect:/categories/grid/1";
    }

    @RequestMapping(value = "/categories/grid/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView grids(@PathVariable Integer pageNumber, ModelAndView model) {
        List<Grid> gridsPerPage = gridService.grids(pageNumber);
        List<Grid> allGrids = gridRepository.findAll();

        Double amountPages = Math.ceil((double) allGrids.size() / gridService.NUMBER_OF_GRID_PER_PAGE);

        model.addObject("pagesAmount", amountPages);
        model.addObject("aLLgrids", allGrids);
        model.addObject("grids", gridsPerPage);
        model.setViewName("grids");
        return model;
    }

}
