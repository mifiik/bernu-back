package ru.avsamoylov.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public Long saveCustomer(Customer customer) {
        return repository.saveCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }
}


