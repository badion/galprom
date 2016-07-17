package com.galprom.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletContext;

@Controller
public class BaseController {

    final Logger LOGGER = Logger.getLogger(this.getClass());

    static final long MAX_IMG_SIZE = 1024 * 1024 * 2L;

    @Autowired
    ServletContext servletContext;
}
