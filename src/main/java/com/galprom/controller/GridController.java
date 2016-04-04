package com.galprom.controller;

import com.galprom.model.Grid;
import com.galprom.repository.GridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GridController {

    @Autowired
    private GridRepository gridRepository;

    @RequestMapping(value = "/categories/grid", method = RequestMethod.GET)
    public ModelAndView getAllGrids(ModelAndView model) {
        List<Grid> grids = gridRepository.findAll();
        model.addObject("grids", grids);
        model.setViewName("grids");
        return model;
    }

}
