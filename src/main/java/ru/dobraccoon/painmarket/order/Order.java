package ru.dobraccoon.painmarket.order;

import lombok.Getter;

@Getter
public class Order {
    private Long id;
    private long productId;
    private long customerId;
    private long price;

    public Order(Long id, Long productId, Long customerId, long price) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        if (price > 0) {
            this.price = price;
        } else {
            throwValidationException("Price", Float.toString(price));
        }
    }

    private void throwValidationException(String valueName, String value) {
        try {
            throw new Exception(String.format("%s can`t be %s", valueName, value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
