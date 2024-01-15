package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.CustomerRowMapper;
import com.dobraccon.painmarket.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void saveCustomer(Customer customer) {
        String sql = String.format(
                "INSERT INTO customers(id, email) VALUES(nextval('customers_sequence'), '%s');"
                , customer.getEmail());
        jdbcTemplate.execute(sql);
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
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    public Customer findByCustomerEmail(String email) {
        String sql = "SELECT * FROM customers WHERE email = :email;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("email", email),
                new CustomerRowMapper());
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET email = :email WHERE id = :id;";
         namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("id", customer.getId())
                        .addValue("email", customer.getEmail()));
    }

    public void deleteCustomer(long id) {
        String sql = "DELETE FROM customers WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    public void deleteCustomer(String email) {
        jdbcTemplate.update("DELETE FROM customers WHERE email = ?;", email);
    }
}
