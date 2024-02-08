package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.order.Order;
import ru.dobraccoon.painmarket.order.OrderService;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest {

    private Order testOrder;
    Customer testCustomer;
    Order createdOrder;
    private final long price = 1000;

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;

    @BeforeAll
    public void initTestData() {

        testCustomer = customerService.create(new Customer(
                null,
                "testImageURL",
                true,
                "test@eamil.com",
                111,
                222222,
                "testFirstName",
                "testLastName",
                "testPassword",
                "testCity",
                "testStreet",
                333
        ));

        testOrder = new Order(
                null,
                testCustomer.getId(),
                1,
                price
        );
    }

    @AfterAll
    public void deleteTestData() {
        orderService.deleteById(createdOrder.getId());
        customerService.deleteById(testCustomer.getId());
    }

    @Test
    public void createTest() {
        createdOrder = orderService.create(testOrder);

        Assertions.assertNotNull(createdOrder);
        Assertions.assertNotNull(orderService.loadById(createdOrder.getId()));
    }

    @Test
    public void CountPriceByCurrencyTest() {
        float testCurrency = 92.1F;
        int testDiscount = 20;
        float expectedValue = 8.68621064061F;

        float result = orderService.countPriceByCurrencyAndDiscount(testOrder, testCurrency, testDiscount);

        Assertions.assertEquals(expectedValue, result);
    }


}
