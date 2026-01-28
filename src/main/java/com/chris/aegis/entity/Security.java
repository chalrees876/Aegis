package com.chris.aegis.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "security", uniqueConstraints = @UniqueConstraint(columnNames = "ticker"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Security {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String ticker;
    
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SecurityType type;
    
    @Column(nullable = false)
    private BigDecimal currentPrice;
    
    @Column
    private String sector;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

enum SecurityType {
    STOCK, CRYPTO, BOND, ETF, FUND, COMMODITY
}