package ru.dobraccoon.painmarket.products;

import lombok.Getter;


@Getter
public class Product {
    private Long id;
    private float primaryPrice;
    private float currentPrice;
    private boolean isNew;
    private String imageUrl;
    private String description;
    private int minDeliveryDays;
    private int maxDeliveryDays;
    private float rating;
    private int reviewCount;


    public Product(Long id, float primaryPrice,
                   float currentPrice, boolean isNew,
                   String imageUrl, String description,
                   int minDeliveryDays, int maxDeliveryDays,
                   float rating, int reviewCount) {
        this.id = id;
        this.primaryPrice = primaryPrice;
        this.currentPrice = currentPrice;
        this.isNew = isNew;
        this.imageUrl = imageUrl;
        this.description = description;
        this.minDeliveryDays = minDeliveryDays;
        this.maxDeliveryDays = maxDeliveryDays;
        this.rating = rating;
        this.reviewCount = reviewCount;
    }
}


