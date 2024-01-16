package com.dobraccon.painmarket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Delivery {
    private Long id;
    private Long orderId;
    private Long customerId;
    private String address;
}
