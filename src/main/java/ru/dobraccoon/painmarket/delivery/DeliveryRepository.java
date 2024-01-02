package ru.dobraccoon.painmarket.delivery;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryRepository {
    private JdbcTemplate jdbcTemplate;

    public DeliveryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Delivery delivery) {
        String sqlInsert = String.format("INSERT INTO delivery(id, order_id, customer_id, address) VALUES(%s,%s,%s,'%s');",
                "nextval('delivery_sequence')",
                delivery.getOrderId(), delivery.getCustomerId(),
                delivery.getAddress());

        jdbcTemplate.execute(sqlInsert);
    }

    public Delivery loadById(long deliveryId) {
        String sqlLoadById = String.format("SELECT * FROM delivery WHERE id = %s", deliveryId);

        return jdbcTemplate.queryForObject(sqlLoadById, new DeliveryRowMapper());
    }

    public List<Delivery> loadAll() {
        String sqlLoadAll = "SELECT * FROM delivery;";

        return jdbcTemplate.query(sqlLoadAll, new DeliveryRowMapper());
    }

    public List<Delivery> loadByAddress(String address) {
        String sqlLoadByAddress = String.format("SELECT * FROM delivery WHERE address = %s", address);

        return jdbcTemplate.query(sqlLoadByAddress, new DeliveryRowMapper());
    }
}






