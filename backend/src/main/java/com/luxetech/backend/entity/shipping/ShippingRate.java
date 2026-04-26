package com.luxetech.backend.entity.shipping;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "shipping_rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingRate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id")
    private ShippingCarrier carrier;

    @Column(length = 50)
    private String province;

    @Column(name = "weight_from")
    private Double weightFrom;

    @Column(name = "weight_to")
    private Double weightTo;

    @Column(nullable = false)
    private BigDecimal price;
}
