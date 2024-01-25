package com.dobraccon.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public Long saveCustomer(Customer customer) {
        return repository.saveCustomer(customer);
    }

    public Customer findByCustomerId(long id) {
        return repository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    public Customer findByCustomerEmail(String email) {
        return repository.findByEmail(email);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    public void deleteCustomerById(long id) {
        repository.deleteByCustomerId(id);
    }

    public void deleteCustomerByEmail(String email) {
        repository.deleteByCustomerEmail(email);
    }
}
