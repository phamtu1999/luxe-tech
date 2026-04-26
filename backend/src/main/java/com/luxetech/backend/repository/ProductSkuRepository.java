package com.luxetech.backend.repository;

import com.luxetech.backend.entity.product.ProductSku;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductSkuRepository extends JpaRepository<ProductSku, UUID> {
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM ProductSku s WHERE s.id = :id")
    Optional<ProductSku> findByIdForUpdate(UUID id);
}
