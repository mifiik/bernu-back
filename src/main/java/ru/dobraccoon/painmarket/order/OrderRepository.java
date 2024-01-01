package ru.dobraccoon.painmarket.order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Order order) {
        String sqlInsert = String.format("INSERT INTO orders(id, product_id, client_id, price)\n" +
                        "VALUES (%s, %s, %s, %s);",
                "nextval('pain_sequence')",
                order.getProductId(),
                order.getClientId(),
                order.getPrice());

        jdbcTemplate.execute(sqlInsert);
    }

    public Order loadById(long orderId) {
        String sqlLoadById = String.format("SELECT * FROM orders WHERE id = %s", orderId);

        return jdbcTemplate.queryForObject(sqlLoadById, new OrderRowMapper());
    }
}
