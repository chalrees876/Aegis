package com.chris.aegis.controller;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.aegis.entity.Portfolio;
import com.chris.aegis.entity.Position;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @GetMapping
    public List<Portfolio> getAllPortfolios() {

        Set<Position> positions = new HashSet<>();
        Position p = new Position();
        p.setQuantity(BigDecimal.ZERO);
        p.setPurchasePrice(BigDecimal.ZERO);
        positions.add(p);

        return List.of(
            new Portfolio(
                1L,
                "Retirement Fund",
                "A diversified portfolio for long-term growth",
                null,
                null,
                null,
                null,
                positions
            ),
            new Portfolio(
                2L,
                "Tech Stocks",
                "Focused on high-growth technology companies",
                null,
                null,
                null,
                null,
                positions
            )
        );
    }
}
