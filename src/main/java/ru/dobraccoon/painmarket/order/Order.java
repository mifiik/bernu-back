package ru.dobraccoon.painmarket.order;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    @Setter
    private final Long id;
    private final long customerId;
    private final long statusId;
    private final long price;

    public Order(Long id, long customerId, long statusId, long price) {
        this.id = id;
        this.customerId = customerId;
        this.statusId = statusId;
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
