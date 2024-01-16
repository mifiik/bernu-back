package com.dobraccon.painmarket.details;

import com.dobraccon.painmarket.model.Customer;
import com.dobraccon.painmarket.model.Order;
import com.dobraccon.painmarket.model.Product;
import com.dobraccon.painmarket.service.CustomerService;
import com.dobraccon.painmarket.service.OrderService;
import com.dobraccon.painmarket.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderDetailService {
    private CustomerService customerService;
    private ProductService productService;
    private OrderService orderService;

    public OrderWithDetails findByOrderIdWithDetails(long id) {
        Order order = orderService.findById(id);
        Product orderProduct = productService.findByProductId(order.getProductId());
        Customer orderCustomer = customerService.findByCustomerId(order.getClientId());
        return new OrderWithDetails(id, orderProduct, orderCustomer);
    }
}
