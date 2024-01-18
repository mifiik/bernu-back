package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.Random;

@Repository
@AllArgsConstructor
public class OrderRepository {

    public Order createOrder(Order order) {
        return new Order(
                new Random().nextLong(), order.getProductId(), order.getClientId(), order.getPrice()
        );
    }
}
