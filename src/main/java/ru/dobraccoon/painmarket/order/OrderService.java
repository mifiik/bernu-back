package ru.dobraccoon.painmarket.order;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Order create(Order newOrder) {
        return orderRepository.create(newOrder);
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

    public float countPriceByCurrencyAndDiscount(Order order, float currency, int discount) {
        float price = order.getPrice();

        return (price-(price/100*discount))/currency;
    }
}
