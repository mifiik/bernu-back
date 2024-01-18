package com.dobraccon.painmarket.details;

import com.dobraccon.painmarket.model.Customer;
import com.dobraccon.painmarket.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderWithDetails {
    private Long orderId;
    private Product orderProduct;
    private Customer orderCustomer;
}
