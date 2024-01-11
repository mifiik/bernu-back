package ru.dobraccoon.painmarket.products;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private long id;
    private float primaryPrice;
    private float currentPrice;
    private int discount;
    private boolean nea;
    private String imageUrl;
    private String description;
    private int minDeliveryDays;
    private int maxDeliveryDays;
    private float rating;
    private int reviewCount;

}


