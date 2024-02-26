package ru.dobraccoon.painmarket.delivery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dobraccoon.painmarket.delivery.history.DeliveryDTO;
import ru.dobraccoon.painmarket.delivery.history.DeliveryDTOService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("delivery")
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryDTOService deliveryDTOService;


    @PostMapping
    public Delivery create(@RequestBody Delivery newDelivery) {
        return deliveryService.create(newDelivery);
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

    @GetMapping("/load-by-status-id/{statusId}")
    public List<Delivery> loadByStatusId(@PathVariable long statusId) {
        return deliveryService.loadByStatusId(statusId);
    }

    @GetMapping("/load-by-postcode/{postcode}")
    public List<Delivery> loadByPostcode(@PathVariable int postcode) {
        return deliveryService.loadByPostcode(postcode);
    }

    @GetMapping("/dto-by-id/{deliveryId}")
    public DeliveryDTO loadDeliveryDTOById(@PathVariable long deliveryId) {
        return deliveryDTOService.loadDeliveryDTOById(deliveryId);
    }
}
