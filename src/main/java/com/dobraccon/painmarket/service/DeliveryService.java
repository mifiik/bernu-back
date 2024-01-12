package com.dobraccon.painmarket.service;

import com.dobraccon.painmarket.model.Delivery;
import com.dobraccon.painmarket.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository repository;

    public void createDelivery(Delivery delivery) {
        repository.createDelivery(delivery);
    }

    public Delivery findByDeliveryId(long id) {
        return repository.findByDeliveryId(id);
    }
}
