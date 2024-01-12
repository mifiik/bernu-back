package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.DeliveryRowMapper;
import com.dobraccon.painmarket.model.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void createDelivery(Delivery delivery) {
        String sql = String.format(
                "INSERT INTO delivery(id, order_id, customer_id, address) " +
                        "VALUES(nextval('delivery_sequence'), '%s', '%s', '%s');",
                delivery.getOrderId(),
                delivery.getCustomerId(),
                delivery.getAddress()
        );
        jdbcTemplate.execute(sql);
    }

    public Delivery findByDeliveryId(long id) {
        String sql = "SELECT * FROM delivery WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new DeliveryRowMapper()
        );
    }
}
