package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {
    @Autowired
    private CustomerService customerService;

    private Customer testCustomer;

    @AfterAll
    public void deleteTest() {
        customerService.deleteById(testCustomer.getId());
    }

    @Test
    public void createTest() {
        testCustomer = customerService.create(new Customer(
                null,
                "ImageTest",
                true,
                "emailTest",
                4900,
                79652796,
                "firstNameTest",
                "lastNameTest",
                "123456",
                "cityTest",
                "streetTest",
                3100
        ));

        Assertions.assertNotNull(testCustomer);
        Assertions.assertNotNull(customerService.loadById(testCustomer.getId()));
    }

}
