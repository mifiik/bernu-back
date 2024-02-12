package ru.avsamoylov.painmarket.delivery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {
    private DeliveryService service;

    @PostMapping
    public Long createDelivery(@RequestBody Delivery delivery) {
        return service.createDelivery(delivery);
    }

    @GetMapping("/{id}")
    public Delivery findByDeliveryId(@PathVariable long id) {
        return service.findByDeliveryId(id);
    }
}
