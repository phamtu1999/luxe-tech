package com.luxetech.backend.entity.user;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "member_tiers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tier_name", unique = true, length = 20)
    private String tierName;

    @Column(name = "min_spending")
    private BigDecimal minSpending;

    @Column(name = "discount_percent")
    private Double discountPercent;
}
