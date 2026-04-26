package com.luxetech.backend.entity.shipping;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "shipping_carriers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingCarrier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;
}
