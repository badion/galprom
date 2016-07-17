package com.galprom.controller;

import com.galprom.model.*;
import com.galprom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class CategoryController extends BaseController{

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllCategories(ModelAndView model) {
        model.addObject("categoryList", categoryRepository.findAll());
        model.setViewName("categories");
        return model;
    }

    @RequestMapping(value = "/categories/img/{id}", method = RequestMethod.GET)
    public HttpServletResponse categoryImage(
            @PathVariable("id") Long id,
            HttpServletResponse response) throws IOException {
        Category category = categoryRepository.findOne(id);
        LOGGER.info("START categoryImage(" + id + ")");
        if (category.getImage() == null) {
            File file = new File(servletContext.getRealPath("/resources/images/" + category.getImgFN()));
            LOGGER.info("FILE '" + file.getAbsolutePath() + "' exists : " + file.exists());
            byte[] bFile = new byte[(int) file.length()];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bFile);
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            category.setImage(bFile);
            categoryRepository.save(category);
            LOGGER.info("FILE '" + file.getAbsolutePath() + "' save to : " + category);
        }
        response.setContentType("image/jpg");
        response.getOutputStream().write(category.getImage());
        response.getOutputStream().flush();
        response.getOutputStream().close();
        LOGGER.info("END categoryImage(" + id + ")");
        return response;
    }

    @RequestMapping(value = "/categories/img/upload/{id}", method = RequestMethod.POST)
    public String uploadImageHandler(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        LOGGER.info("START uploadImageHandler(" + id + ")");
        Category category = categoryRepository.getOne(id);
        if (file.getSize() < MAX_IMG_SIZE) {
            category.setImage(file.getBytes());
        } else {
            LOGGER.warn("file size is to long : " + file.getSize() + " b\tmax : " + MAX_IMG_SIZE);
        }
        categoryRepository.save(category);
        LOGGER.info("END uploadImageHandler(" + id + ")");
        return "redirect:/";
    }
}
