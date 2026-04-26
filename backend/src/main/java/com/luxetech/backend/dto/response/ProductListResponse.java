package com.luxetech.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {
    private UUID id;
    private String name;
    private String slug;
    private BigDecimal basePrice;
    private String thumbnailUrl;
    private String brandName;
    private String categoryName;
    private Boolean isFeatured;
}
