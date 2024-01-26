package com.dobraccon.painmarket.util;

import com.dobraccon.painmarket.customers.Customer;
import com.github.javafaker.Faker;

public class RandomCustomer {
    private static final Faker faker = new Faker();

    public static Customer getRandomCustomer() {
        return new Customer(null, faker.internet().emailAddress());
    }
}
