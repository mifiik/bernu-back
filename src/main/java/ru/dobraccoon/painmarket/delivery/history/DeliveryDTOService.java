package ru.dobraccoon.painmarket.delivery.history;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.delivery.Delivery;
import ru.dobraccoon.painmarket.delivery.DeliveryService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;

@Service
@AllArgsConstructor
public class DeliveryDTOService {
    private DeliveryService deliveryService;
    private OrderService orderService;

    public DeliveryDTO loadDeliveryDTOById(long deliveryId) {
        Delivery delivery = deliveryService.loadById(deliveryId);
        Order order = orderService.loadById(delivery.getOrderId());

        return new DeliveryDTO(
                delivery.getId(),
                order,
                delivery.getCity(),
                delivery.getStreet(),
                delivery.getPostcode(),
                delivery.getInformationForCourier(),
                delivery.getDeliveryPrice(),
                delivery.getDiscount(),
                delivery.getTotalAmount()
        );
    }
}
