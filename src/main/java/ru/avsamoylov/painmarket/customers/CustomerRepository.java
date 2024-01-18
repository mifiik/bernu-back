package ru.avsamoylov.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Random;
@Repository
@AllArgsConstructor
public class CustomerRepository {
    public Customer saveCustomer(Customer customer) {
        return new Customer(
                new Random().nextLong(), customer.getEmail()
        );
    }
}
