package com.luxetech.backend.controller;

import com.luxetech.backend.dto.response.ProductListResponse;
import com.luxetech.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductListResponse>> getProducts(
            @PageableDefault(size = 12, sort = "createdAt") Pageable pageable) {
        return ResponseEntity.ok(productService.getProducts(pageable));
    }
}
