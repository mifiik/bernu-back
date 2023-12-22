package ru.dobraccoon.painmarket.products;

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
        if (price > 0) {
            this.price = price;
        } else {
            try {
                throw new Exception(String.format("Price can`t be %s", price));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            try {
                throw new Exception(String.format("Discount can`t be %s", discount));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public float countPriceWithDiscount() {
        return price - price / 100 * discount;
    }
}


