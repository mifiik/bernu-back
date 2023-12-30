package ru.dobraccoon.painmarket.delivery;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryRepository {
    private JdbcTemplate jdbcTemplate;

    public DeliveryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Delivery delivery) {
        String sqlInsert = String.format("INSERT INTO delivery(id, order_id, customer_id, address) VALUES(%s,%s,%s,'%s');", Math.random(), delivery.getOrderId(), delivery.getCustomerId(), delivery.getAddress());
        jdbcTemplate.execute(sqlInsert);
    }
}






