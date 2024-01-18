package ru.dobraccoon.painmarket.delivery;

import org.springframework.web.bind.annotation.*;
import ru.dobraccoon.painmarket.delivery.history.DeliveryDTO;
import ru.dobraccoon.painmarket.delivery.history.DeliveryDTOService;

import java.util.List;

@RestController
@RequestMapping("delivery")
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryDTOService deliveryDTOService;

    public DeliveryController(DeliveryService deliveryService, DeliveryDTOService deliveryDTOService) {
        this.deliveryService = deliveryService;
        this.deliveryDTOService = deliveryDTOService;
    }

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.create(delivery);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        deliveryService.deleteById(id);
    }

    @DeleteMapping("{orderId}/{customerId}")
    public void deleteByOrderId(@PathVariable long orderId) {
        deliveryService.deleteByOrderId(orderId);
    }

    @DeleteMapping("/by-postcode/{postcode}")
    public void deleteByPostcode(@PathVariable int postcode) {
        deliveryService.deleteByPostcode(postcode);
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

    @GetMapping("/load-by-postcode/{postcode}")
    public List<Delivery> loadByPostcode(@PathVariable int postcode) {
        return deliveryService.loadByPostcode(postcode);
    }

    @GetMapping("/load-by-deliveryId/{deliveryId}")
    public DeliveryDTO loadDeliveryDTOById(@PathVariable long deliveryId) {
        return deliveryDTOService.loadDeliveryDTOById(deliveryId);
    }
}
