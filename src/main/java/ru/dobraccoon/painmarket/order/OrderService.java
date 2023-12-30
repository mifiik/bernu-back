package ru.dobraccoon.painmarket.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.create(order);
    }
}
