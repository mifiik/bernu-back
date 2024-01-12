package com.dobraccon.painmarket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private long id;
    private long productId;
    private long clientId;
    private long price;

}
