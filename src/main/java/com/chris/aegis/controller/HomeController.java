package com.chris.aegis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Receives web traffic
@Controller
public class HomeController {


    @RequestMapping("/")
    //model is a container for data you want to pass to the view
    public String index(Model model) {

        model.addAttribute("title", "Aegis Investment Management");

        return "index.html";
    }
}
