package ru.dobraccoon.painmarket.order;


import org.springframework.web.bind.annotation.*;
import ru.dobraccoon.painmarket.order.details.OrderDetailService;
import ru.dobraccoon.painmarket.order.details.OrderWithDetails;
import ru.dobraccoon.painmarket.order.history.OrderHistoryDTO;
import ru.dobraccoon.painmarket.order.history.OrderHistoryService;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService orderService;
    private OrderHistoryService orderHistoryService;
    private OrderDetailService orderDetailService;

    public OrderController(OrderService orderService, OrderHistoryService orderHistoryService,
                           OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.orderHistoryService = orderHistoryService;
        this.orderDetailService = orderDetailService;
    }

    @PostMapping
    public Order create(@RequestBody Order newOrder) {
        return orderService.create(newOrder);
    }

    @GetMapping("/history-by-customer-id/{customerId}")
    public OrderHistoryDTO loadOrderHistoryByCustomerId(@PathVariable long customerId) {
        return orderHistoryService.loadOrderHistoryByCustomerId(customerId);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        orderService.deleteById(id);
    }

    @DeleteMapping("/delete-by-customer-id/{customerId}")
    public void deleteByCustomerId(@PathVariable long customerId) {
        orderService.deleteByCustomerId(customerId);
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

    @GetMapping("/load-by-customer-id/{customerId}")
    public List<Order> loadByCustomerId(@PathVariable long customerId) {
        return orderService.loadByCustomerId(customerId);
    }

    @GetMapping("/by-id-with-details/{orderId}")
    public OrderWithDetails loadByOrderId(@PathVariable long orderId) {
        return orderDetailService.loadByOrderId(orderId);
    }
}
