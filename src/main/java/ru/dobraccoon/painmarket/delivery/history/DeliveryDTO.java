package ru.dobraccoon.painmarket.delivery.history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.dobraccoon.painmarket.delivery.DeliveryStatus;
import ru.dobraccoon.painmarket.order.Order;

@Getter
@AllArgsConstructor
public class DeliveryDTO {
    private long id;
    private Order order;
    private String city;
    private String street;
    private int postcode;
    private String informationForCourier;
    private float deliveryPrice;
    private int discount;
    private float totalAmount;
    private DeliveryStatus deliveryStatus;
}
