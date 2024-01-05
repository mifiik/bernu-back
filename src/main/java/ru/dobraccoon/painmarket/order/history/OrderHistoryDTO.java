package ru.dobraccoon.painmarket.order.history;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderHistoryDTO {
    private Long customerId;
    private String customerEmail;
    private List<OrderDTO> customerOrder;
}

