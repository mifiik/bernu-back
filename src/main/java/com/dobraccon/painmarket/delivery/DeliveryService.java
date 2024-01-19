package com.dobraccon.painmarket.delivery;

import com.dobraccon.painmarket.delivery.Delivery;
import com.dobraccon.painmarket.delivery.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository repository;

    public Long createDelivery(Delivery delivery) {
        return repository.createDelivery(delivery);
    }

    public Delivery findByDeliveryId(long id) {
        return repository.findByDeliveryId(id);
    }

    public List<Delivery> findAllDelivery() {
        return repository.findAllDelivery();
    }

    public List<Delivery> findDeliveryByAddress(String address) {
        return repository.findDeliveryByAddress(address);
    }

    public void deleteDeliveryByAddress(String address) {
        repository.deleteDeliveryByAddress(address);
    }

    public void deleteDeliveryByOrderIdAndCustomerId(long orderId, long customerId) {
        repository.deleteDeliveryByOrderIdAndCustomerId(orderId, customerId);
    }
}
