package com.luxetech.backend.repository;

import com.luxetech.backend.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    // Basic CRUD provided by JpaRepository
}
