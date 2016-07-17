package com.galprom.controller;

import com.galprom.mail.MailSender;
import com.galprom.mail.User;
import com.galprom.model.Category;
import com.galprom.model.product.Grid;
import com.galprom.model.product.Product;
import com.galprom.model.SubCategory;
import com.galprom.repository.CategoryRepository;
import com.galprom.repository.GridRepository;
import com.galprom.repository.ProductRepository;
import com.galprom.repository.SubCategoryRepository;
import com.galprom.service.GridServiceImpl;
import com.galprom.validator.GridValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class GridController extends BaseController{

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

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
        model.addObject("gridPage", gridPage).setViewName("grid/grids");
        return model;
    }

    @RequestMapping(value = {"/categories/newGrid/{idSub}"}, method = RequestMethod.GET)
    public String newGrid(ModelMap model, @PathVariable("idSub") Long idSub) {
        Product grid = new Grid();
        grid.setSubcategory(subCategoryRepository.findOne(idSub));
        model.addAttribute("grid", grid);
        model.addAttribute("edit", false);
        return "grid/grid_new";
    }

    @RequestMapping(value = {"/categories/newGridSubCategory"}, method = RequestMethod.POST)
    public String newGridSubCategory(@Valid SubCategory subCategory, ModelMap model) {
        return "grid/grid_new_sub_category_successful";
    }

    @RequestMapping(value = {"/categories/newGrid/{idSub}"}, method = RequestMethod.POST)
    public String newGridAction(@Valid Grid grid, ModelMap model, @PathVariable("idSub") Long idSub) {
        SubCategory subCategory = subCategoryRepository.findOne(idSub);
        System.out.println(subCategory.getProducts());
        grid.setFromClass("Grid");
        grid.setSubcategory(subCategory);
        subCategory.getProducts().add(grid);
        subCategoryRepository.save(subCategory);
        model.addAttribute("success", "Сітка " + grid.getName() + " " + " додана успішно");
        return "grid/grid_new_successful";
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
        return "grid/grid_new";
    }

    @RequestMapping(value = "/categories/grid/{id}/edit", method = RequestMethod.POST)
    public String editGridAction(@Valid Grid grid) {
        Product oldGrid = productRepository.getOne(grid.getId());
        grid.setSubcategory(oldGrid.getSubcategory());
        grid.setFromClass(oldGrid.getFromClass());
        gridRepository.save(grid);
        return "redirect:/categories/grid";
    }

    @RequestMapping(value = "/categories/grid/{id}/send_mail", method = RequestMethod.POST)
    public Object sendMailAction(@PathVariable("id") Long id,
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

    @RequestMapping(value = "/categories/grid/img/{id}", method = RequestMethod.GET)
    public HttpServletResponse gridCategoryImage(
            @PathVariable("id") Long id,
            HttpServletResponse response) throws IOException {
        SubCategory subCategory = subCategoryRepository.findOne(id);
        LOGGER.info("START gridCategoryImage(" + id + ")");
        response.setContentType("image/jpg");
        if (subCategory.getImage() != null) {
            response.getOutputStream().write(subCategory.getImage());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
        LOGGER.info("END gridCategoryImage(" + id + ")");
        return response;
    }

    @RequestMapping(value = "/categories/grid/img/upload/{id}", method = RequestMethod.POST)
    public String uploadGridSubCategoryImageHandler(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        LOGGER.info("START uploadGridSubCategoryImageHandler(" + id + ")");
        SubCategory subCategory = subCategoryRepository.getOne(id);
        if (file.getSize() < MAX_IMG_SIZE) {
            subCategory.setImage(file.getBytes());
        } else {
            LOGGER.warn("file size is to long : " + file.getSize() + " b\tmax : " + MAX_IMG_SIZE);
        }
        subCategoryRepository.save(subCategory);
        LOGGER.info("END uploadGridSubCategoryImageHandler(" + id + ")");
        return "redirect:/categories/grid";
    }

}
