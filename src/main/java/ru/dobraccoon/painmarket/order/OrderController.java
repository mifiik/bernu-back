package ru.dobraccoon.painmarket.order;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @GetMapping("/{orderId}")
    public Order loadById(@PathVariable long orderId) {
        return orderService.loadById(orderId);
    }
}
