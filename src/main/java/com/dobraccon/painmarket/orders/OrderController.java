package com.dobraccon.painmarket.orders;

import com.dobraccon.painmarket.orders.details.OrderDetailService;
import com.dobraccon.painmarket.orders.details.OrderWithDetails;
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

    @GetMapping("/{orderId}")
    public Order findByOrderId(@PathVariable Long orderId) {
        return service.findById(orderId);
    }

    @GetMapping("/load-all")
    public List<Order> findAllOrders() {
        return service.findAll();
    }

    @GetMapping("/find-by-customer-id/{customerId}")
    public List<Order> findOrderByCustomerId(@PathVariable Long customerId) {
        return service.findByCustomerId(customerId);
    }

    @GetMapping("/by-id-with-details/{orderId}")
    public OrderWithDetails findByOrderIdWithDetails(@PathVariable Long orderId) {
        return orderDetailService.findByOrderIdWithDetails(orderId);
    }

    @DeleteMapping("/delete-by-customer-id/{customerId}")
    public void deleteByCustomerId(@PathVariable Long customerId) {
        service.deleteById(customerId);
    }

    @DeleteMapping("/delete-by-price/{price}")
    public void deleteByPrice(@PathVariable float price) {
        service.deleteByPrice(price);
    }
}
