package ru.dobraccoon.painmarket.customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    public Customer create(Customer newCustomer) {
        return new Customer((long) 1001, newCustomer.getEmail());
    }
}
