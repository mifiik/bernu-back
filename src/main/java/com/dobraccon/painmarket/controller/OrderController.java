package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.details.OrderDetailService;
import com.dobraccon.painmarket.details.OrderWithDetails;
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
    private OrderDetailService orderDetailService;

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
    public List<Order> findOrderByCustomerId(@PathVariable Long customerId) {
        return service.findOrderByCustomerId(customerId);
    }

    @GetMapping("/by-id-with-details/{orderId}")
    public OrderWithDetails findByIdOrderWithDetails(@PathVariable Long orderId) {
        return orderDetailService.getOrderWithDetailsById(orderId);
    }
}
