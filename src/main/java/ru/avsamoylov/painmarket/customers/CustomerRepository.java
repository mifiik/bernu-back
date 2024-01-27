package ru.avsamoylov.painmarket.customers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers(id, email) VALUES (nextval('customer_sequence'), ':email') RETURNING id;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("email", customer.getEmail()),
                Long.class);
    }

    public Customer findById(long id) {
        String sql = "SELECT * FROM customer WHERE id = :id;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("id", id),
                new CustomerRowMapper()
        );
    }
}