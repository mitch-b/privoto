package com.mitchbarry.privoto.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AboutController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public void getAbout() {
        return;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "index";
    }

}
