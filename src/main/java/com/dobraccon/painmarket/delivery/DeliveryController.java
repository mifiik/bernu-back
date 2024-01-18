package com.dobraccon.painmarket.delivery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/load-all")
    public List<Delivery> findAllDelivery() {
        return service.findAllDelivery();
    }

    @GetMapping("/find-by-address/{address}")
    public List<Delivery> findDeliveryByAddress(@PathVariable String address) {
        return service.findDeliveryByAddress(address);
    }

    @DeleteMapping("/delete-by-address/{address}")
    public void deleteDeliveryByAddress(@PathVariable String address) {
        service.deleteDeliveryByAddress(address);
    }

    @DeleteMapping("/delete-by-orderId{orderId}/by-customerId/{customerId}")
    public void deleteDeliveryByOrderIdAndCustomerId(@PathVariable long orderId, @PathVariable long customerId) {
        service.deleteDeliveryByOrderIdAndCustomerId(orderId, customerId);
    }
}
