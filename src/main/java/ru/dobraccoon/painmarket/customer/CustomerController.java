package ru.dobraccoon.painmarket.customer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer newCustomer) {
        return customerService.create(newCustomer);
    }

    @GetMapping("/{customerId}")
    public Customer loadById(@PathVariable long customerId) {
        return customerService.loadById(customerId);
    }

}


