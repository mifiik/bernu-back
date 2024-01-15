package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.CustomerRowMapper;
import com.dobraccon.painmarket.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Long saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers(id, email) VALUES (nextval('customers_sequence'), :email) RETURNING id;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("email", customer.getEmail()),
                Long.class);
    }

    public Customer findByCustomerId(long id) {
        String sql = "SELECT * FROM  customers WHERE id = :id;";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new CustomerRowMapper()
        );
    }

    public List<Customer> findAllCustomer() {
        String sql = "SELECT * FROM customers";
        return namedParameterJdbcTemplate.query(sql, new CustomerRowMapper());
    }

    public Customer findByCustomerEmail(String email) {
        String sql = "SELECT * FROM customers WHERE email = :email;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("email", email),
                new CustomerRowMapper());
    }
}
