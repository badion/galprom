package com.galprom.controller;

import com.galprom.mail.MailSender;
import com.galprom.mail.User;
import com.galprom.model.Grid;
import com.galprom.model.Product;
import com.galprom.model.SubCategory;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GridRepository;
import com.galprom.repository.ProductRepository;
import com.galprom.repository.SubCategoryRepository;
import com.galprom.service.GridServiceImpl;
import com.galprom.validator.GridValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
        Map<SubCategory, List<Grid>> gridPage = new TreeMap<>();

        categoryRepository.findBylink("grid")
                .getSubCategories()
                .forEach(subCategory ->
                        gridPage.put(subCategory, subCategory.getProducts()
                                .stream()
                                .map(product -> (Grid) product)
                                .collect(Collectors.toList())));
        model.addObject("gridPage", gridPage).setViewName("grids");
        return model;
    }

    @RequestMapping(value = {"/categories/newGrid/{idSub}"}, method = RequestMethod.GET)
    public String newGrid(ModelMap model, @PathVariable("idSub") Long idSub) {
        Product grid = new Grid();
        grid.setSubcategory(subCategoryRepository.findOne(idSub));
        model.addAttribute("grid", grid);
        model.addAttribute("edit", false);
        return "grid_new";
    }

    @RequestMapping(value = {"/categories/newGrid/{idSub}"}, method = RequestMethod.POST)
    public String newGridAction(@Valid Grid grid, BindingResult result, ModelMap model, @PathVariable("idSub") Long idSub) {
        SubCategory subCategory = subCategoryRepository.findOne(idSub);
        System.out.println(subCategory.getProducts());
        grid.setFromClass("Grid");
        grid.setSubcategory(subCategory);
        subCategory.getProducts().add(grid);
//        gridValidator.validate(grid, result);
//        if (result.hasErrors()) {
//            return "grid_new";
//        }

        subCategoryRepository.save(subCategory);
        model.addAttribute("success", "Сітка " + grid.getName() + " " + " додана успішно");
        return "grid_new_succesful";
    }

    @RequestMapping(value = "/categories/grid/{id}/delete", method = RequestMethod.GET)
    public String deleteGrid(@PathVariable("id") Long id) {
        gridRepository.delete(gridRepository.findOne(id));
        return "redirect:/categories/grid";
    }

    @RequestMapping(value = "/categories/grid/{id}/edit", method = RequestMethod.GET)
    public String editGrid(@PathVariable("id") Long id, ModelMap model) {
        Grid grid = gridRepository.findOne(id);
        model.addAttribute("grid", grid);
        model.addAttribute("edit", true);
        return "grid_new";
    }

    @RequestMapping(value = "/categories/grid/{id}/edit", method = RequestMethod.POST)
    public String editGridAction(@Valid Grid grid, BindingResult result, ModelMap model) {
        Product oldGrid = productRepository.getOne(grid.getId());
        grid.setSubcategory(oldGrid.getSubcategory());
        grid.setFromClass(oldGrid.getFromClass());
        gridRepository.save(grid);
        return "redirect:/categories/grid";
    }

    @RequestMapping(value = "/categories/grid/{id}/send_mail", method = RequestMethod.POST)
    public String sendMailAction(@PathVariable("id") Long id,
                                 @RequestParam("name") String name,
                                 @RequestParam("tel") String tel,
                                 @RequestParam("comment") String comment,
                                 @RequestParam("email") String email
    ) throws MessagingException, IOException, URISyntaxException {
        Product product = productRepository.getOne(id);
        User user = new User(name, tel, email);
        String itemUrl = product.toString();
        String subject = product.getName();
        new MailSender().makeSender(user, comment, itemUrl, subject);
        return "redirect:/categories/grid";
    }
}
