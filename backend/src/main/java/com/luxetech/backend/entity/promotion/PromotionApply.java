package com.luxetech.backend.entity.promotion;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "promotion_applies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionApply {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @Column(name = "applied_to_type", length = 20)
    private String appliedToType; // PRODUCT, CATEGORY

    @Column(name = "applied_to_id")
    private UUID appliedToId;
}
