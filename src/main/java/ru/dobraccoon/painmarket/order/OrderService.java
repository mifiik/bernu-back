package ru.dobraccoon.painmarket.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.create(order);
    }

    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    public void deleteByCustomerId(long customerId) {
        orderRepository.deleteByCustomerId(customerId);
    }

    public void deleteByPrice(long price) {
        orderRepository.deleteByPrice(price);
    }

    public Order loadById(long orderId) {
        return orderRepository.loadById(orderId);
    }

    public List<Order> loadAll() {
        return orderRepository.loadAll();
    }

    public List<Order> loadByCustomerId(long customerId) {
        return orderRepository.loadByCustomerId(customerId);
    }
}
