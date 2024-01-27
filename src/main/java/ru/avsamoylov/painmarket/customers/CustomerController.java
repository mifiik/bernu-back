package ru.avsamoylov.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/customer")
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
}
