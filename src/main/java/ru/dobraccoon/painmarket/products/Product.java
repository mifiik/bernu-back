package ru.dobraccoon.painmarket.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Product {
    @Setter
    private Long id;
    private float primaryPrice;
    private float currentPrice;
    private int discount;
    private boolean newProduct;
    private String imageUrl;
    private String description;
    private int minDeliveryDays;
    private int maxDeliveryDays;
    private float rating;
    private int reviewCount;

}


