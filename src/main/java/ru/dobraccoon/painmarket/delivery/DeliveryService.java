package ru.dobraccoon.painmarket.delivery;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void create(Delivery delivery) {
        deliveryRepository.create(delivery);
    }
}
