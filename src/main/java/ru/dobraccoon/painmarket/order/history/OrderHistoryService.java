package ru.dobraccoon.painmarket.order.history;

import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;

import java.util.List;

@Service
public class OrderHistoryService {
    public CustomerService customerService;
    public OrderService orderService;

    public OrderHistoryService(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    public OrderHistoryDTO loadOrderHistoryByCustomerId(long customerId){
        Customer customer = customerService.loadById(customerId);
        List<Order> customerOrders = orderService.loadByClientId(customerId);

        return new OrderHistoryDTO(
               customer.getId(),
                customer.getEmail(),
                customerOrders
        );
    }
}
