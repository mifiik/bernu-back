package com.dobraccon.painmarket.orders.histoty;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrdersHistoryDTO {
    private Long customerId;
    private String customerEmail;
    private List<CustomerOrdersDTO> customerOrders;
}
