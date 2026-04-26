package com.luxetech.backend.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class OrderRequest {

    @NotBlank(message = "Địa chỉ nhận hàng không được để trống")
    private String shippingAddress;

    @NotBlank(message = "Phương thức thanh toán không được để trống")
    private String paymentMethod;

    private String couponCode;

    @NotEmpty(message = "Giỏ hàng không được để trống")
    @Valid
    private List<OrderItemRequest> items;

    @Data
    public static class OrderItemRequest {
        @NotNull(message = "ID sản phẩm không được để trống")
        private UUID skuId;

        @NotNull(message = "Số lượng không được để trống")
        private Integer quantity;
    }
}
