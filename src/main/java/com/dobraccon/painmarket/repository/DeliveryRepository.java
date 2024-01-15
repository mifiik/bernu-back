package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.DeliveryRowMapper;
import com.dobraccon.painmarket.model.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long createDelivery(Delivery delivery) {
        String sql = "INSERT INTO delivery(id, order_id, customer_id, address) VALUES (" +
                "(nextval('delivery_sequence'), :orderId, :customerId, :address));";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("orderId", delivery.getOrderId())
                        .addValue("customerId", delivery.getCustomerId())
                        .addValue("address", delivery.getAddress()),
                Long.class);
    }

    public Delivery findByDeliveryId(long id) {
        String sql = "SELECT * FROM delivery WHERE id = :id;";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new DeliveryRowMapper()
        );
    }

    public List<Delivery> findAllDelivery() {
        String sql = "SELECT * FROM delivery";
        return namedParameterJdbcTemplate.query(sql, new DeliveryRowMapper());
    }

    public List<Delivery> findDeliveryByAddress(String address) {
        String sql = "SELECT * FROM delivery WHERE address = :address;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource("address", address),
                new DeliveryRowMapper());
    }
}
