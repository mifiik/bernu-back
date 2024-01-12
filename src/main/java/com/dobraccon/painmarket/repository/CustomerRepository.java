package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.CustomerRowMapper;
import com.dobraccon.painmarket.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT * FROM  customer WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new CustomerRowMapper()
        );
    }
}
