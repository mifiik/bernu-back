package ru.avsamoylov.painmarket.delivery;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository repository;
    public Long createDelivery(Delivery delivery) {
        return repository.createDelivery(delivery);
    }
}
