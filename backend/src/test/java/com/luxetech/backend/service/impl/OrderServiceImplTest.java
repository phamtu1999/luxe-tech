package com.luxetech.backend.service.impl;

import com.luxetech.backend.dto.request.OrderRequest;
import com.luxetech.backend.dto.response.OrderResponse;
import com.luxetech.backend.entity.order.Order;
import com.luxetech.backend.entity.product.Product;
import com.luxetech.backend.entity.product.ProductSku;
import com.luxetech.backend.entity.user.MemberTier;
import com.luxetech.backend.entity.user.Profile;
import com.luxetech.backend.exception.InsufficientStockException;
import com.luxetech.backend.exception.ResourceNotFoundException;
import com.luxetech.backend.repository.OrderRepository;
import com.luxetech.backend.repository.ProductSkuRepository;
import com.luxetech.backend.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private ProductSkuRepository skuRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private UUID userId;
    private UUID skuId;
    private Profile profile;
    private ProductSku sku;
    private OrderRequest orderRequest;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        skuId = UUID.randomUUID();

        MemberTier tier = MemberTier.builder()
                .tierName("S-Vip")
                .discountPercent(5.0) // 5% discount
                .build();

        profile = Profile.builder()
                .id(userId)
                .fullName("Test User")
                .tier(tier)
                .totalSpent(BigDecimal.ZERO)
                .build();

        Product product = Product.builder()
                .basePrice(new BigDecimal("1000"))
                .build();

        sku = ProductSku.builder()
                .id(skuId)
                .product(product)
                .skuCode("SKU-001")
                .priceOverride(new BigDecimal("200")) // Total price = 1000 + 200 = 1200
                .stockTotal(10)
                .build();

        OrderRequest.OrderItemRequest itemRequest = new OrderRequest.OrderItemRequest();
        itemRequest.setSkuId(skuId);
        itemRequest.setQuantity(2);

        orderRequest = new OrderRequest();
        orderRequest.setShippingAddress("123 Street");
        orderRequest.setPaymentMethod("COD");
        orderRequest.setItems(List.of(itemRequest));
    }

    @Test
    @DisplayName("Đặt hàng thành công - Tính toán đúng giá và giảm giá")
    void createOrder_Success() {
        // Arrange
        when(profileRepository.findById(userId)).thenReturn(Optional.of(profile));
        when(skuRepository.findByIdForUpdate(skuId)).thenReturn(Optional.of(sku));
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        OrderResponse response = orderService.createOrder(userId, orderRequest);

        // Assert
        assertNotNull(response);
        assertEquals("Đặt hàng thành công!", response.getMessage());
        
        // Total before discount: 1200 * 2 = 2400
        // Discount 5%: 2400 * 0.05 = 120
        // Total after discount: 2400 - 120 = 2280
        assertEquals(new BigDecimal("2280.00"), response.getTotalAmount());
        assertEquals(8, sku.getStockTotal()); // Stock reduced from 10 to 8
        
        verify(skuRepository, times(1)).save(sku);
        verify(orderRepository, times(1)).save(any(Order.class));
        verify(profileRepository, times(1)).save(profile);
    }

    @Test
    @DisplayName("Đặt hàng thất bại - Hết hàng")
    void createOrder_InsufficientStock() {
        // Arrange
        orderRequest.getItems().get(0).setQuantity(15); // Requesting more than 10
        when(profileRepository.findById(userId)).thenReturn(Optional.of(profile));
        when(skuRepository.findByIdForUpdate(skuId)).thenReturn(Optional.of(sku));

        // Act & Assert
        assertThrows(InsufficientStockException.class, () -> {
            orderService.createOrder(userId, orderRequest);
        });

        verify(skuRepository, never()).save(any());
        verify(orderRepository, never()).save(any());
    }

    @Test
    @DisplayName("Đặt hàng thất bại - Không tìm thấy người dùng")
    void createOrder_UserNotFound() {
        // Arrange
        when(profileRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            orderService.createOrder(userId, orderRequest);
        });
    }
}
