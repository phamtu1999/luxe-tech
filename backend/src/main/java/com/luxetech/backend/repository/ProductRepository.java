package com.luxetech.backend.repository;

import com.luxetech.backend.dto.response.ProductListResponse;
import com.luxetech.backend.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT new com.luxetech.backend.dto.response.ProductListResponse(" +
           "p.id, p.name, p.slug, p.basePrice, p.thumbnailUrl, p.brand.name, p.category.name, p.isFeatured) " +
           "FROM Product p")
    Page<ProductListResponse> findAllProjected(Pageable pageable);
}
