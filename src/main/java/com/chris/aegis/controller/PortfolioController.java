package com.chris.aegis.controller;


import java.util.List;
import com.chris.aegis.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chris.aegis.model.Portfolio;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @Autowired
    PortfolioService service;

    @GetMapping
    public List<Portfolio> getPortfolios(){
        return service.getPortfolios();
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable Long portfolioId){
        return service.getPortfolioById(portfolioId);
    }

    @PostMapping
    public void addPortfolio(@RequestBody Portfolio portfolio){
        service.addPortfolio(portfolio);
    }

    @PutMapping
    public void updatePortfolio(@RequestBody Portfolio portfolio){
        service.updatePortfolio(portfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId){
        service.deletePortfolio(portfolioId);
    }
}
