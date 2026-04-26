package com.luxetech.backend.service.impl;

import com.luxetech.backend.dto.request.OrderRequest;
import com.luxetech.backend.dto.response.OrderResponse;
import com.luxetech.backend.entity.order.Order;
import com.luxetech.backend.entity.order.OrderItem;
import com.luxetech.backend.entity.product.ProductSku;
import com.luxetech.backend.entity.user.Profile;
import com.luxetech.backend.exception.InsufficientStockException;
import com.luxetech.backend.exception.ResourceNotFoundException;
import com.luxetech.backend.repository.OrderRepository;
import com.luxetech.backend.repository.ProductSkuRepository;
import com.luxetech.backend.repository.ProfileRepository;
import com.luxetech.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductSkuRepository skuRepository;
    private final OrderRepository orderRepository;
    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public OrderResponse createOrder(UUID userId, OrderRequest request) {
        // 1. Lấy thông tin khách hàng và hạng thành viên (Smember)
        Profile profile = profileRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thông tin người dùng"));

        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderItem> orderItems = new ArrayList<>();

        // 2. Duyệt qua từng sản phẩm trong giỏ hàng
        for (OrderRequest.OrderItemRequest itemReq : request.getItems()) {
            // Sử dụng Pessimistic Lock để tránh tranh chấp kho (Race Condition)
            ProductSku sku = skuRepository.findByIdForUpdate(itemReq.getSkuId())
                    .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại: " + itemReq.getSkuId()));

            // Kiểm tra tồn kho
            if (sku.getStockTotal() < itemReq.getQuantity()) {
                throw new InsufficientStockException("Sản phẩm " + sku.getSkuCode() + " đã hết hàng hoặc không đủ số lượng");
            }

            // Tính giá (Giá gốc + Giá override của SKU)
            BigDecimal unitPrice = sku.getProduct().getBasePrice().add(
                    sku.getPriceOverride() != null ? sku.getPriceOverride() : BigDecimal.ZERO
            );
            BigDecimal lineTotal = unitPrice.multiply(BigDecimal.valueOf(itemReq.getQuantity()));
            totalAmount = totalAmount.add(lineTotal);

            // Trừ kho ngay lập tức
            sku.setStockTotal(sku.getStockTotal() - itemReq.getQuantity());
            skuRepository.save(sku);

            // Tạo bản ghi chi tiết đơn hàng
            OrderItem orderItem = OrderItem.builder()
                    .sku(sku)
                    .quantity(itemReq.getQuantity())
                    .priceAtPurchase(unitPrice)
                    .build();
            orderItems.add(orderItem);
        }

        // 3. Áp dụng giảm giá Smember (Nếu có)
        if (profile.getTier() != null && profile.getTier().getDiscountPercent() != null) {
            double discountPercent = profile.getTier().getDiscountPercent();
            BigDecimal discountValue = totalAmount.multiply(BigDecimal.valueOf(discountPercent / 100.0));
            totalAmount = totalAmount.subtract(discountValue);
        }

        // 4. Lưu đơn hàng vào Database
        Order order = Order.builder()
                .user(profile)
                .orderNumber("LUX-" + System.currentTimeMillis()) // Mã đơn hàng duy nhất
                .totalAmount(totalAmount)
                .shippingAddress(request.getShippingAddress())
                .status("PENDING")
                .paymentMethod(request.getPaymentMethod())
                .items(orderItems)
                .build();
        
        // Gán ngược reference cho OrderItem
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }
        
        Order savedOrder = orderRepository.save(order);

        // 5. Cập nhật tổng chi tiêu để khách hàng thăng hạng Smember
        profile.setTotalSpent(profile.getTotalSpent().add(totalAmount));
        profileRepository.save(profile);

        return OrderResponse.builder()
                .orderNumber(savedOrder.getOrderNumber())
                .totalAmount(savedOrder.getTotalAmount())
                .status(savedOrder.getStatus())
                .message("Đặt hàng thành công!")
                .build();
    }
}
