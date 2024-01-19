package com.dobraccon.painmarket.orders.details;

import com.dobraccon.painmarket.customers.Customer;
import com.dobraccon.painmarket.orders.Order;
import com.dobraccon.painmarket.products.Product;
import com.dobraccon.painmarket.customers.CustomerService;
import com.dobraccon.painmarket.orders.OrderService;
import com.dobraccon.painmarket.products.ProductService;
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
        Customer orderCustomer = customerService.findByCustomerId(order.getCustomerId());
        return new OrderWithDetails(id, orderProduct, orderCustomer);
    }
}
