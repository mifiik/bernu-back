package com.dobraccon.painmarket.util;

import com.dobraccon.painmarket.products.Product;
import com.github.javafaker.Faker;

import java.util.Random;

public class RandomProduct {
    private static final Faker faker = new Faker();

    public static Product getRandomProduct() {
        return new Product(null,
                faker.commerce().productName(),
                new Random().nextFloat(),
                faker.number().numberBetween(0, 100));
    }
}
