package ru.dobraccoon.painmarket.delivery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public void update(@RequestBody Delivery delivery) {
        deliveryService.update(delivery);
    }

    @GetMapping("/{deliveryId}")
    public Delivery loadById(@PathVariable long deliveryId) {
        return deliveryService.loadById(deliveryId);
    }

    @GetMapping("load-all")
    public List<Delivery> loadAll() {
        return deliveryService.loadAll();
    }

    @GetMapping("/load-by-address/{address}")
    public List<Delivery> loadByAddress(@PathVariable String address) {
        return deliveryService.loadByAddress(address);
    }
}
