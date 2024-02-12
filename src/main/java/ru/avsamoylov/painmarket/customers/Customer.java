package ru.avsamoylov.painmarket.customers;

import lombok.Getter;

@Getter
public class Customer {
    private final Long id;
    private final String email;

    public Customer(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
