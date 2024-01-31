package ru.dobraccoon.painmarket.delivery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void create(Delivery delivery) {
        deliveryRepository.create(delivery);
    }

    public void deleteById(long id) {
        deliveryRepository.deleteById(id);
    }

    public void deleteByOrderId(long orderId) {
        deliveryRepository.deleteByOrderId(orderId);
    }

    public void deleteByPostcode(int postcode) {
        deliveryRepository.deleteByPostcode(postcode);
    }

    public void update(Delivery delivery) {
        deliveryRepository.update(delivery);
    }

    public Delivery loadById(long deliveryId) {
        return deliveryRepository.loadById(deliveryId);
    }

    public List<Delivery> loadAll() {
        return deliveryRepository.loadAll();
    }

    public List<Delivery> loadByPostcode(int postcode) {
        return deliveryRepository.loadByPostcode(postcode);
    }
}

