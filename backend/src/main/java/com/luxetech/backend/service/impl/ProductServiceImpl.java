package com.luxetech.backend.service.impl;

import com.luxetech.backend.dto.response.ProductListResponse;
import com.luxetech.backend.repository.ProductRepository;
import com.luxetech.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductListResponse> getProducts(Pageable pageable) {
        return productRepository.findAllProjected(pageable);
    }
}
