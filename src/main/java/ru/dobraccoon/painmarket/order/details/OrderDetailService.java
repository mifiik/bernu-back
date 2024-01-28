package ru.dobraccoon.painmarket.order.details;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailService {
    private CustomerService customerService;
    private ProductService productService;
    private OrderService orderService;


    public OrderWithDetails loadByOrderId(long orderId) {
        Order order = orderService.loadById(orderId);
        List<Product> products = productService.loadByOrderId(orderId);
        Customer customer = customerService.loadById(order.getCustomerId());

        return new OrderWithDetails(
                orderId,
                order.getPrice(),
                products,
                customer,
                OrderStatus.getStatusNameById(order.getStatusId())
        );
    }
}
