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
        String sql = "INSERT INTO customer(id, email) VALUE (nextval('customers_sequence'), :email) RETURNING id;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource().addValue("email", customer.getEmail()), Long.class);
    }
    public void updateCustomer(Customer customer){
        String sql = "UPDATE customer SET email = :email WHERE id = :id;";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("id", customer.getId())
                .addValue("email", customer.getEmail()));
    }
}
