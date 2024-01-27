package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public Long createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    public Order findById(long id) {
        return orderRepository.findById(id);
    }
}
