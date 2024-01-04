package ru.dobraccoon.painmarket.order;


import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        orderService.deleteById(id);
    }

    @DeleteMapping("/delete-by-clientId/{clientId}")
    public void deleteByClientId(@PathVariable long clientId) {
        orderService.deleteByClientId(clientId);
    }

    @DeleteMapping("/delete-by-price/{price}")
    public void deleteByPrice(@PathVariable long price) {
        orderService.deleteByPrice(price);
    }

    @GetMapping("/{orderId}")
    public Order loadById(@PathVariable long orderId) {
        return orderService.loadById(orderId);
    }

    @GetMapping("/load-all")
    public List<Order> loadAll() {
        return orderService.loadAll();
    }

    @GetMapping("/load-by-client-id/{clientId}")
    public List<Order> loadByClientId(@PathVariable long clientId) {
        return orderService.loadByClientId(clientId);
    }
}
