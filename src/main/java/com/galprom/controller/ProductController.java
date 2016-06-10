package com.galprom.controller;

import com.galprom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product/{id}/send_mail", method = RequestMethod.GET)
    public ModelAndView getAllGrids(ModelAndView model, @PathVariable("id") Long id) {
        System.out.println("SEND MAIL " + productRepository.getOne(id));
        return model;
    }
}
