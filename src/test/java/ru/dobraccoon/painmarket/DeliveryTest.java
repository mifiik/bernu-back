package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.delivery.Delivery;
import ru.dobraccoon.painmarket.delivery.DeliveryService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeliveryTest {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;

    private Delivery testDelivery;
    private Order testOrder;
    private Customer testCustomer;

    @BeforeAll
    public void initTestCustomerData() {
        testCustomer = customerService.create(new Customer(
                null,
                "ImageTest",
                true,
                "emailTest",
                490,
                79652796,
                "firstNameTest",
                "lastNameTest",
                "passwordTest",
                "cityTest",
                "streetTest",
                3100
        ));

        testOrder = orderService.create(new Order(
                null,
                testCustomer.getId(),
                1,
                222
        ));
    }

    @AfterAll
    public void deleteData() {
        deliveryService.deleteById(testDelivery.getId());
        orderService.deleteById(testOrder.getId());
        customerService.deleteById(testCustomer.getId());
    }

    @Test
    public void createTest() {
        testDelivery = deliveryService.create(new Delivery(
                null,
                testOrder.getId(),
                "cityTest",
                "streetTest",
                2100,
                "informForCourierTest",
                10.5F,
                10,
                2F,
                1
        ));

        Assertions.assertNotNull(testDelivery.getId());
        Assertions.assertNotNull(customerService.loadById(testCustomer.getId()));
        Assertions.assertNotNull(orderService.loadById(testOrder.getId()));
    }
}
