package com.dobraccon.painmarket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Delivery {
    private Long id;
    private long orderId;
    private long customerId;
    private String address;
}
