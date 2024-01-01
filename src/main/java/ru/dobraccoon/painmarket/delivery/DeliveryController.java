package ru.dobraccoon.painmarket.delivery;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delivery")
public class DeliveryController {
    private DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.create(delivery);
    }

    @GetMapping("/{deliveryId}")
    public Delivery loadById(@PathVariable long deliveryId) {
        return deliveryService.loadById(deliveryId);

    }
}
