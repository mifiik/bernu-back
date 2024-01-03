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
            throwValidationException("Price", Float.toString(price));
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throwValidationException("Discount", Integer.toString(discount));
        }
    }

    public float countPriceWithDiscount() {
        return price - price / 100 * discount;
    }

    private void throwValidationException(String valueName, String value) {
        try {
            throw new Exception(String.format("%s can`t be %s", valueName, value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


