package ru.dobraccoon.painmarket.order.details;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductService;

@Service
@AllArgsConstructor
public class OrderDetailService {
    CustomerService customerService;
    ProductService productService;
    OrderService orderService;

    public OrderWithDetails loadByOrderId(long orderId) {
        Order order = orderService.loadById(orderId);
        Product product = productService.loadById(order.getProductId());
        Customer customer = customerService.loadById(order.getCustomerId());

        return new OrderWithDetails(
                orderId,
                product,
                customer
        );
    }
}
