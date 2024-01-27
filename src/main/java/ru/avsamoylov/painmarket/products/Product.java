package ru.avsamoylov.painmarket.products;

import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private float price;
    private int discount;

    public Product(Long id, String name, float price, int discount) {
        this.id = id;
        this.name = name;
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less than or equal to zero");
        }
        this.price = price;
        if (discount >=100 || discount <=0) {
            throw new IllegalArgumentException("The discount cannot be less than 0% and no more than 100%");
        }
        this.discount = discount;
    }
}
