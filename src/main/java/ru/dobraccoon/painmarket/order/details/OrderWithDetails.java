package ru.dobraccoon.painmarket.order.details;

import lombok.Getter;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.products.Product;

@Getter
public class OrderWithDetails {
    private long orderId;
    private Product orderProduct;
    private Customer orderCustomer;

    public OrderWithDetails(long orderId, Product orderProduct, Customer orderCustomer) {
        this.orderId = orderId;
        this.orderCustomer = orderCustomer;
        this.orderProduct = orderProduct;
    }
}
