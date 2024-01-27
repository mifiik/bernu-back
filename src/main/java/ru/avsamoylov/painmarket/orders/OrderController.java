package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public Long createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{orderid}")
    public Order findByOrderId(@PathVariable Long orderid) {
        return orderService.findById(orderid);
    }
}
