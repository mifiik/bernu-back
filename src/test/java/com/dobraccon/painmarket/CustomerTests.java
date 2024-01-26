package com.dobraccon.painmarket;

import com.dobraccon.painmarket.customers.Customer;
import com.dobraccon.painmarket.customers.CustomerController;
import com.dobraccon.painmarket.docker.AbstractPostgresContainer;
import com.dobraccon.painmarket.util.RandomCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerTests extends AbstractPostgresContainer {
    @Autowired
    CustomerController controller;
    Customer randomCustomer;
    Long customerId;

    @BeforeEach
    public void setUp() {
        randomCustomer = RandomCustomer.getRandomCustomer();
    }

    @AfterEach
    public void tearDown() {
        if (customerId != null) {
            controller.deleteCustomerById(customerId);
        }
    }

    @Test
    public void testingTheMethodsToSaveCustomerAndFindCustomerById() {
        String expectedEmail = randomCustomer.getEmail();
        customerId = controller.saveCustomer(randomCustomer);
        Customer customer = controller.findByCustomerId(customerId);

        assertThat(customer.getEmail()).isEqualTo(expectedEmail);
    }

    @Test
    public void testingTheMethodToFindCustomerByEmail() {
        String expectedEmail = randomCustomer.getEmail();
        customerId = controller.saveCustomer(randomCustomer);
        Customer customer = controller.findByCustomerEmail(expectedEmail);

        assertThat(customer.getEmail()).isEqualTo(expectedEmail);
    }

    @Test
    public void testingTheMethodToFindAllCustomers() {
        List<Customer> customers = controller.findAllCustomers();

        assertThat(customers.size()).isEqualTo(5);
    }

    @Test
    public void testingTheMethodToDeleteCustomerById() {
        String expectedEmail = randomCustomer.getEmail();
        Long id = controller.saveCustomer(randomCustomer);
        Customer expectedCustomer = controller.findByCustomerEmail(expectedEmail);
        assertThat(expectedCustomer.getEmail()).isEqualTo(expectedEmail);

        controller.deleteCustomerById(id);
        List<Customer> customers = controller.findAllCustomers();
        customers.forEach(x -> assertThat(x.getEmail()).isNotEqualTo(expectedEmail));
    }

    @Test
    public void testingTheMethodToDeleteCustomerByEmail() {
        String expectedEmail = randomCustomer.getEmail();
        Long id = controller.saveCustomer(randomCustomer);
        Customer expectedCustomer = controller.findByCustomerId(id);
        assertThat(expectedCustomer.getEmail()).isEqualTo(expectedEmail);

        controller.deleteCustomerByEmail(expectedEmail);
        List<Customer> customers = controller.findAllCustomers();
        customers.forEach(x -> assertThat(x.getEmail()).isNotEqualTo(expectedEmail));
    }

    @Test
    public void testingTheMethodToUpdateCustomer() {
        String expectedEmail = randomCustomer.getEmail();
        customerId = controller.saveCustomer(randomCustomer);
        Customer customer = controller.findByCustomerEmail(expectedEmail);
        assertThat(customer.getEmail()).isEqualTo(expectedEmail);

        String updatingEmail = RandomCustomer.getRandomCustomer().getEmail();
        controller.updateCustomer(new Customer(customerId, updatingEmail));
        Customer actualCustomer = controller.findByCustomerId(customerId);

        assertThat(actualCustomer.getEmail()).isEqualTo(updatingEmail);
    }
}
