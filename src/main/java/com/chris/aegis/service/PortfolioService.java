package com.chris.aegis.service;

import com.chris.aegis.model.Portfolio;
import com.chris.aegis.repository.PortfolioRepo;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Setter
    private PortfolioRepo repo;

    public PortfolioService(PortfolioRepo repo){this.repo = repo;}

    public Portfolio getPortfolioById(Long portfolioId) {
        return this.repo.findById(portfolioId).orElse(null);
    }

    public ResponseEntity<Portfolio> addPortfolio(Portfolio portfolio) {
        Portfolio saved = this.repo.save(portfolio);
        return ResponseEntity.status(201).body(saved);
    }

    public ResponseEntity<Portfolio> update(Portfolio portfolio) {
        Portfolio updated = this.repo.save(portfolio);
        return ResponseEntity.status(200).body(portfolio);
    }

    public void deletePortfolio(Long portfolioId) {
        this.repo.deleteById(portfolioId);
    }

    public List<Portfolio> getAllPortfolios() {
        return this.repo.findAll();
    }
}
