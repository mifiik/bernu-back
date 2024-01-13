package com.dobraccon.painmarket.service;

import com.dobraccon.painmarket.model.Order;
import com.dobraccon.painmarket.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository repository;

    public void createOrder(Order order) {
        repository.createOrder(order);
    }

    public Order findByOrderId(long id) {
        return repository.findByOrderId(id);
    }

    public List<Order> findAllOrders() {
        return repository.findAllOrders();
    }

    public List<Order> findOrderByCustomerId(long customerId) {
        return repository.findOrdersByConsumerId(customerId);
    }
}
