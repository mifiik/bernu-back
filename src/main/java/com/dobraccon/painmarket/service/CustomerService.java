package com.dobraccon.painmarket.service;

import com.dobraccon.painmarket.model.Customer;
import com.dobraccon.painmarket.repository.CustomerRepository;
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
        return repository.findByCustomerId(id);
    }

    public List<Customer> findAllCustomers() {
        return repository.findAllCustomer();
    }

    public Customer findByCustomerEmail(String email) {
        return repository.findByCustomerEmail(email);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    public void deleteCustomer(long id) {
        repository.deleteCustomer(id);
    }

    public void deleteCustomer(String email) {
        repository.deleteCustomer(email);
    }
}
