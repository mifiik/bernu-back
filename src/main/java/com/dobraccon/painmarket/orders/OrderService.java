package com.dobraccon.painmarket.orders;

import com.dobraccon.painmarket.orders.Order;
import com.dobraccon.painmarket.orders.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository repository;

    public Long createOrder(Order order) {
        return repository.createOrder(order);
    }

    public Order findById(long id) {
        return repository.findById(id);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public List<Order> findByCustomerId(long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public void deleteById(long customerId) {
        repository.deleteByCustomerId(customerId);
    }

    public void deleteByPrice(float price) {
        repository.deleteByPrice(price);
    }
}
