package com.dobraccon.painmarket.orders.histoty;

import com.dobraccon.painmarket.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerOrdersDTO {
    private Long orderId;
    private Product orderProduct;
    private long customerId;
    private float orderPrice;
}
