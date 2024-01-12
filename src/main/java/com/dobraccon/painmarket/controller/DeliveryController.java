package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.model.Delivery;
import com.dobraccon.painmarket.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {
    private DeliveryService service;

    @PostMapping
    public void createDelivery(@RequestBody Delivery delivery) {
        service.createDelivery(delivery);
    }

    @GetMapping("/{id}")
    public Delivery findByDeliveryId(@PathVariable long id) {
        return service.findByDeliveryId(id);
    }
}
