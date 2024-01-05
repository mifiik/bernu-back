package ru.dobraccoon.painmarket.order.history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.dobraccoon.painmarket.products.Product;

@AllArgsConstructor
@Getter
public class OrderDTO {
    private long orderId;
    private Product product;
    private long clientId;
    private long price;
}
