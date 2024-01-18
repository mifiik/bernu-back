package com.dobraccon.painmarket.orders.histoty;

import com.dobraccon.painmarket.customers.Customer;
import com.dobraccon.painmarket.customers.CustomerService;
import com.dobraccon.painmarket.orders.Order;
import com.dobraccon.painmarket.orders.OrderService;
import com.dobraccon.painmarket.products.Product;
import com.dobraccon.painmarket.products.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrdersHistoryService {
    private CustomerService customerService;
    private OrderService orderService;
    private ProductService productService;

    public OrdersHistoryDTO getOrdersByCustomerId(final Long customerId) {
        Customer customer = customerService.findByCustomerId(customerId);
        String customerEmail = customer.getEmail();
        List<Order> orders = orderService.findAll();
        List<CustomerOrdersDTO> ordersDTOList = null;
        for (Order order : orders) {
            if (order.getCustomerId() == customerId) {
                long productId = order.getProductId();
                Product product = productService.findByProductId(productId);
                assert false;
                ordersDTOList.add(new CustomerOrdersDTO(order.getId(), product, customerId, order.getPrice()));
            }
        }
        return new OrdersHistoryDTO(customerId, customerEmail, ordersDTOList);
    }
}
