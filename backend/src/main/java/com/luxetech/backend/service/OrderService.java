package com.luxetech.backend.service;

import com.luxetech.backend.dto.request.OrderRequest;
import com.luxetech.backend.dto.response.OrderResponse;
import java.util.UUID;

public interface OrderService {
    OrderResponse createOrder(UUID userId, OrderRequest request);
}
