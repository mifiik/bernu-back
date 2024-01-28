package ru.dobraccoon.painmarket.order.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.products.Product;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderWithDetails {
    private long orderId;
    private long price;
    private List<Product> products;
    private Customer orderCustomer;
    private OrderStatus orderStatus;
}
