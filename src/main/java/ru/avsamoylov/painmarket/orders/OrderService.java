package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }
}
