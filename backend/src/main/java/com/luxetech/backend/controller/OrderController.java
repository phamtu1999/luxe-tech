package com.luxetech.backend.controller;

import com.luxetech.backend.dto.request.OrderRequest;
import com.luxetech.backend.dto.response.OrderResponse;
import com.luxetech.backend.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(
            @RequestHeader("X-User-Id") UUID userId, // Tạm thời lấy User ID từ Header cho đến khi có Security đầy đủ
            @Valid @RequestBody OrderRequest request) {
        
        OrderResponse response = orderService.createOrder(userId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
