package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.model.Customer;
import com.dobraccon.painmarket.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findByCustomerId(@PathVariable long id) {
        return service.findByCustomerId(id);
    }
}
