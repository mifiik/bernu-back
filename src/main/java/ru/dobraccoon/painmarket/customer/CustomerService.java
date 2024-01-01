package ru.dobraccoon.painmarket.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer newCustomer) {
        return customerRepository.create(newCustomer);
    }

    public Customer loadById(long customerId) {
        return customerRepository.loadById(customerId);
    }
}
