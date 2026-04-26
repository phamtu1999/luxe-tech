package com.luxetech.backend.entity.warranty;

import com.luxetech.backend.entity.product.ProductSku;
import com.luxetech.backend.entity.order.Order;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "product_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    private ProductSku sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "serial_number", unique = true, length = 100)
    private String serialNumber;

    @Column(length = 20)
    @Builder.Default
    private String status = "IN_STOCK"; // IN_STOCK, SOLD, WARRANTY, RETURNED

    @Column(name = "warranty_expiry")
    private OffsetDateTime warrantyExpiry;
}
