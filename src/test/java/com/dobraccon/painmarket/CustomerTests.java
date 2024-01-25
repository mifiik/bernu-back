package com.dobraccon.painmarket;

import com.dobraccon.painmarket.customers.Customer;
import com.dobraccon.painmarket.customers.CustomerController;
import com.dobraccon.painmarket.customers.CustomerRepository;
import com.dobraccon.painmarket.docker.AbstractPostgresContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomerTests extends AbstractPostgresContainer {
    @Autowired
    CustomerRepository repository;
    @Autowired
    CustomerController controller;

    @Test
    public void smokeTest() {
        Customer customer = repository.findById(103);
        System.out.println(customer.getEmail());

        Customer customer1 = controller.findByCustomerId(101);
        System.out.println(customer1.getEmail());

        int size = controller.findAllCustomers().size();
        System.out.println(size);
    }
}
