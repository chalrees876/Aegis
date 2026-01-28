package com.chris.aegis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.aegis.entity.Portfolio;

@RestController
public class PortfolioController {

    @RequestMapping("/portfolio")
    public Portfolio sayPortfolio() {
        return new Portfolio();
    }
}
