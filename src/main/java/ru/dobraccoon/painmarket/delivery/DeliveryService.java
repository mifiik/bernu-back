package ru.dobraccoon.painmarket.delivery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void create(Delivery delivery) {
        deliveryRepository.create(delivery);
    }

    public void deleteById(long id) {
        deliveryRepository.deleteById(id);
    }

    public void deleteByOrderIdAndCustomerId(long orderId, long customerId) {
        deliveryRepository.deleteByOrderIdAndCustomerId(orderId, customerId);
    }

    public void deleteByAddress(String address) {
        deliveryRepository.deleteByAddress(address);
    }

    public Delivery loadById(long deliveryId) {
        return deliveryRepository.loadById(deliveryId);
    }

    public List<Delivery> loadAll() {
        return deliveryRepository.loadAll();
    }

    public List<Delivery> loadByAddress(String address) {
        return deliveryRepository.loadByAddress(address);
    }
}

