package ru.dobraccoon.painmarket.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.create(order);
    }

    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    public void deleteByClientId(long clientId) {
        orderRepository.deleteByClientId(clientId);
    }

    public void deleteByPrice(long price) {
        orderRepository.deleteByPrice(price);
    }

    public void update(Order order) {
        orderRepository.update(order);
    }

    public Order loadById(long orderId) {
        return orderRepository.loadById(orderId);
    }

    public List<Order> loadAll() {
        return orderRepository.loadAll();
    }

    public List<Order> loadByClientId(long clientId) {
        return orderRepository.loadByClientId(clientId);
    }
}
