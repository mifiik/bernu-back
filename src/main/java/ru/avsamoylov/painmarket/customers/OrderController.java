package ru.avsamoylov.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.avsamoylov.painmarket1.product.Order;
import ru.avsamoylov.painmarket1.service.OrderService;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
       return orderService.createOrder(order);
    }
}
