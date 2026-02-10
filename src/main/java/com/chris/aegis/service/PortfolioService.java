package com.chris.aegis.service;

import com.chris.aegis.model.Portfolio;
import com.chris.aegis.model.Position;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class PortfolioService {

    @Getter
    private final List<Portfolio> portfolios;

    public PortfolioService(){
        Position p = new Position();
        Position p2 = new Position();

        Set<Position> ps = new HashSet<>();
        ps.add(p);
        ps.add(p2);

        portfolios = new ArrayList<>(Arrays.asList(new Portfolio(
                        2L,
                        "two",
                        "description",
                        BigDecimal.ZERO,
                        null,
                        null,
                        null,
                        ps

                ),
                new Portfolio(
                        6L,
                        "six",
                        "description",
                        BigDecimal.ZERO,
                        null,
                        null,
                        null,
                        ps
                )));
    }

    public Portfolio getPortfolioById(Long portfolioId) {
        return portfolios.stream()
                .filter(p -> p.getId() == portfolioId)
                .findFirst().orElse(null);
    }

    public void addPortfolio(Portfolio portfolio){
        portfolios.add(portfolio);
    }

    public void updatePortfolio(Portfolio portfolio) {
        int i = 0;
        for(Portfolio p : portfolios){
            if (p.getId() == portfolio.getId()){
                break;
            }
            i++;
        }
        portfolios.set(i, portfolio);
    }

    public void deletePortfolio(Long portfolioId) {
        portfolios.removeIf(p -> Objects.equals(p.getId(), portfolioId));
    }
}
