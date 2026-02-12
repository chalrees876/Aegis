package com.chris.aegis.controller;


import java.util.List;

import com.chris.aegis.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chris.aegis.model.Portfolio;

@RestController
@RequestMapping("/api/portfolios")
@CrossOrigin
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    };

    @GetMapping
    public List<Portfolio> getPortfolios(){
        return service.getAllPortfolios();
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable Long portfolioId){
        return service.getPortfolioById(portfolioId);
    }

    @PostMapping
    public ResponseEntity<Portfolio> addPortfolio(@RequestBody Portfolio portfolio){
        return service.addPortfolio(portfolio);
    }

    @PutMapping
    public ResponseEntity<Portfolio> updatePortfolio(@RequestBody Portfolio portfolio){
        return service.update(portfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId){
        service.deletePortfolio(portfolioId);
    }
}
