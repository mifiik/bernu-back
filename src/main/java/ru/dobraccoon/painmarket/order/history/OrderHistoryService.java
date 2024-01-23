package ru.dobraccoon.painmarket.order.history;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderHistoryService {
    CustomerService customerService;
    OrderService orderService;

    public OrderHistoryDTO loadOrderHistoryByCustomerId(long customerId) {
        Customer customer = customerService.loadById(customerId);
        List<Order> orderList = orderService.loadByCustomerId(customerId);

        return new OrderHistoryDTO(
                customer.getId(),
                customer.getEmail(),
                orderList
        );
    }
}
