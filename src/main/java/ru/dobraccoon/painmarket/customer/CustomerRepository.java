package ru.dobraccoon.painmarket.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer create(Customer newCustomer) {
        String createSQL = String.format("INSERT INTO customer(id, email) VALUES (%s, '%s')",
                "nextval('customer_sequence')", newCustomer.getEmail());
        jdbcTemplate.execute(createSQL);
        return null;
    }

    public Customer loadById(long customerId) {
        String sqlLoadById = String.format("SELECT * FROM customer WHERE id = %s", customerId);

        return jdbcTemplate.queryForObject(sqlLoadById, new CustomerRowMapper());
    }

    public List<Customer> loadAll(){
        String sqlLoadAll = "SELECT * FROM customer;";

        return jdbcTemplate.query(sqlLoadAll, new CustomerRowMapper());
    }
}
