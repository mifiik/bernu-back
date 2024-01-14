package ru.dobraccoon.painmarket.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void create(Customer newCustomer) {
        customerRepository.create(newCustomer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        customerRepository.deleteByEmail(email);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public Customer loadById(long customerId) {
        return customerRepository.loadById(customerId);
    }

    public List<Customer> loadAll() {
        return customerRepository.loadAll();
    }
}
