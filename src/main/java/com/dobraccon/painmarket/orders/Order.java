package com.dobraccon.painmarket.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private long productId;
    private long customerId;
    private long price;

}
