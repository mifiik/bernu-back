package com.dobraccon.painmarket.details;

import com.dobraccon.painmarket.model.Order;
import com.dobraccon.painmarket.service.CustomerService;
import com.dobraccon.painmarket.service.OrderService;
import com.dobraccon.painmarket.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Service
public class OrderDetailService {
    private CustomerService customerService;
    private ProductService productService;
    private OrderService orderService;

    public OrderWithDetails getOrderWithDetailsById(Long id) {
        Order order = orderService.findByOrderId(id);
        return new OrderWithDetails(
                id, productService.findByProductId(order.getProductId())
                , customerService.findByCustomerId(order.getClientId()));
    }
}
