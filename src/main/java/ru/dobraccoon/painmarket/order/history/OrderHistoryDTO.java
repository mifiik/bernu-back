package ru.dobraccoon.painmarket.order.history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.dobraccoon.painmarket.order.Order;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderHistoryDTO {
    private long customerId;
    private String customerEmail;
    private List<Order> customerOrders;
}
