package ru.dobraccoon.painmarket.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer newCustomer) {
        return customerRepository.create(newCustomer);
    }

    public void update(Customer customer) {
        customerRepository.Update(customer);
    }

    public Customer loadById(long customerId) {
        return customerRepository.loadById(customerId);
    }

    public List<Customer> loadAll() {
        return customerRepository.loadAll();
    }
}
