package com.chris.aegis.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riskMetric")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiskMetric {

    @Id
    private Integer id;

    @OneToOne(mappedBy = "riskMetric", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Portfolio portfolio;

    @Column(nullable = false)
    private BigDecimal beta;
    
    @Column
    private BigDecimal volatility;

    @Column
    private BigDecimal sharpeRatio;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime calculatedAt;
}
