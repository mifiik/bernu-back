package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.model.Customer;
import com.dobraccon.painmarket.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public Long saveCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findByCustomerId(@PathVariable long id) {
        return service.findByCustomerId(id);
    }

    @GetMapping("/load-all")
    public List<Customer> findAllCustomers() {
        return service.findAllCustomers();
    }

    @GetMapping("/find-by-email/{email}")
    public Customer findByCustomerEmail(@PathVariable String email) {
        return service.findByCustomerEmail(email);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteCustomerById(@PathVariable long id) {
        service.deleteCustomerById(id);
    }

    @DeleteMapping("/delete-by-email/{email}")
    public void deleteCustomerByEmail(@PathVariable String email) {
        service.deleteCustomerByEmail(email);
    }
}
