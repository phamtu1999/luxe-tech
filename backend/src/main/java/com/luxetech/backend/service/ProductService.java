package com.luxetech.backend.service;

import com.luxetech.backend.dto.response.ProductListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductListResponse> getProducts(Pageable pageable);
}
