package ru.dobraccoon.painmarket.order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Order order) {
        String sqlInsert = String.format("INSERT INTO orders(id, product_id, customer_id, price)\n" +
                        "VALUES (%s, %s, %s, %s);",
                "nextval('order_sequence')",
                order.getProductId(),
                order.getCustomerId(),
                order.getPrice());

        jdbcTemplate.execute(sqlInsert);
    }

    public void deleteById(long id) {
        String sqlDeleteById = String.format("DELETE FROM orders WHERE id = %s;", id);
        jdbcTemplate.execute(sqlDeleteById);
    }

    public void deleteByCustomerId(long customerId) {
        String sqlDeleteByCustomerId = String.format("DELETE FROM orders WHERE customer_id = %s;", customerId);
        jdbcTemplate.execute(sqlDeleteByCustomerId);
    }

    public void deleteByPrice(long price) {
        String sqlDeleteByPrice = String.format("DELETE FROM orders WHERE price = %s;", price);
        jdbcTemplate.execute(sqlDeleteByPrice);
    }

    public void update(Order order) {
        String sqlUpdate = String.format(
                """
                        UPDATE orders SET product_id = %s, customer_id = %s, price = %s
                        WHERE id = %s;""",
                order.getProductId(),
                order.getCustomerId(),
                order.getPrice(),
                order.getId()
        );
        jdbcTemplate.update(sqlUpdate);

    }

    public Order loadById(long orderId) {
        String sqlLoadById = String.format("SELECT * FROM orders WHERE id = %s", orderId);

        return jdbcTemplate.queryForObject(sqlLoadById, new OrderRowMapper());
    }

    public List<Order> loadAll() {
        String sqlLoadAll = "SELECT * FROM orders;";

        return jdbcTemplate.query(sqlLoadAll, new OrderRowMapper());
    }

    public List<Order> loadByCustomerId(long customerId) {
        String sqlLoadByCustomerId = String.format("SELECT * FROM orders WHERE customer_id = %s", customerId);
        return jdbcTemplate.query(sqlLoadByCustomerId, new OrderRowMapper());
    }
}
