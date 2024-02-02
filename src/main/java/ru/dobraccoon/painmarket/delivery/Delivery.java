package ru.dobraccoon.painmarket.delivery;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Delivery {
    @Setter
    private Long id;
    private long orderId;
    private String city;
    private String street;
    private int postcode;
    private String informationForCourier;
    private float deliveryPrice;
    private int discount;
    private float totalAmount;
    private long statusId;
}
