package com.chris.aegis.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;
    
    @Column(nullable = false)
    private BigDecimal quantity;
    
    @Column(nullable = false)
    private BigDecimal purchasePrice;
    
    @Column(nullable = false)
    private BigDecimal currentPrice;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    /**
     * Calculate current market value of this position
     */
    public BigDecimal getCurrentValue() {
        if (quantity == null || purchasePrice == null || currentPrice == null) {
            return BigDecimal.ZERO;
        }
        return quantity.multiply(currentPrice);
    }
    
    /**
     * Calculate gain/loss on this position
     */
    public BigDecimal getUnrealizedGainLoss() {
        if (quantity == null || purchasePrice == null || currentPrice == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal initialValue = quantity.multiply(purchasePrice);
        BigDecimal currentValue = getCurrentValue();
        return currentValue.subtract(initialValue);
    }
    
    /**
     * Calculate percentage return
     */
    public BigDecimal getReturnPercentage() {
        if (quantity == null || purchasePrice == null || currentPrice == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal initialValue = quantity.multiply(purchasePrice);
        BigDecimal gainLoss = getUnrealizedGainLoss();
        return gainLoss.divide(initialValue, 4, java.math.RoundingMode.HALF_UP);
    }
}
