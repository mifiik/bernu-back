package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.model.Order;
import com.dobraccon.painmarket.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private OrderService service;

    @PostMapping
    public Long createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order findByOrderId(@PathVariable long id) {
        return service.findByOrderId(id);
    }

    @GetMapping("/load-all")
    public List<Order> findAllOrders() {
        return service.findAllOrders();
    }

    @GetMapping("/find-by-customer-id/{customerId}")
    public List<Order> findOrderByCustomerId(@PathVariable long customerId) {
        return service.findOrderByCustomerId(customerId);
    }
}
