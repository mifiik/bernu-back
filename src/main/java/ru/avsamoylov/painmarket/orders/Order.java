package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private  long id;
    private long productId;
    private long customerId;
    private long price;
}
