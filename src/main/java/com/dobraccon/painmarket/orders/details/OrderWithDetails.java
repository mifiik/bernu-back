package com.dobraccon.painmarket.orders.details;

import com.dobraccon.painmarket.customers.Customer;
import com.dobraccon.painmarket.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderWithDetails {
    private Long orderId;
    private Product orderProduct;
    private Customer orderCustomer;
}
