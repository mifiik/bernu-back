package ru.dobraccoon.painmarket.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer newCustomer) {
        return customerService.create(newCustomer);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        customerService.deleteById(id);
    }

    @DeleteMapping("/delete-by-email/{email}")
    public void deleteByEmail(@PathVariable String email) {
        customerService.deleteByEmail(email);
    }

    @PutMapping
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @GetMapping("{customerId}")
    public Customer loadById(@PathVariable long customerId) {
        return customerService.loadById(customerId);
    }

    @GetMapping("load-all")
    public List<Customer> loadAll() {
        return customerService.loadAll();
    }

}


