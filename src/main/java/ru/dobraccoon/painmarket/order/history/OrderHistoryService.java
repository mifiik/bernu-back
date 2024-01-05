package ru.dobraccoon.painmarket.order.history;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderHistoryService {
    CustomerService customerService;
    OrderService orderService;
    ProductService productService;

    public OrderHistoryDTO loadByCustomerId(long customerId) {
        Customer customer = customerService.loadById(customerId);
        List<Order> orderList = orderService.loadByClientId(customerId);
        List<OrderDTO> customerOrdersInfo = new ArrayList<>();

        for (Order order : orderList) {
            Product product = productService.loadById(order.getProductId());
            OrderDTO orderDTO = new OrderDTO(order.getId(), product, order.getClientId(), order.getPrice());
            customerOrdersInfo.add(orderDTO);
        }

        return new OrderHistoryDTO(
                customer.getId(),
                customer.getEmail(),
                customerOrdersInfo
        );
    }
}
