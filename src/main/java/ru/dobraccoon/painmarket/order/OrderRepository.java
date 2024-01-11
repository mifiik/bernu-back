package ru.dobraccoon.painmarket.order;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final static String sqlInsert = """
            INSERT INTO orders(id, product_id, customer_id, price)
                        VALUES (:id, :productId, :customerId, :price)""";
    private final static String sqlDeleteById = "DELETE FROM orders WHERE id = :id";
    private final static String sqlDeleteByCustomerId = "DELETE FROM orders WHERE customer_id = :customerId";
    private final static String sqlDeleteByPrice = "DELETE FROM orders WHERE price = :price;";
    private final static String sqlUpdate = """
            UPDATE orders
            SET product_id  = :productId,
                customer_id = :customerId,
                price       = :price
            WHERE id = :orderId
            """;
    private final static String sqlLoadById = "SELECT * FROM orders WHERE id = :orderId";
    private final static String sqlLoadAll = "SELECT * FROM orders;";
    private final static String sqlLoadByCustomerId = "SELECT * FROM orders WHERE customer_id = :customerId";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(Order order) {
        namedParameterJdbcTemplate.update(sqlInsert,
                new MapSqlParameterSource()
                        .addValue("id", order.getId())
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice()));
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("id", id));
    }

    public void deleteByCustomerId(long customerId) {
        namedParameterJdbcTemplate.update(
                sqlDeleteByCustomerId,
                new MapSqlParameterSource("customerId", customerId));
    }

    public void deleteByPrice(long price) {
        namedParameterJdbcTemplate.update(
                sqlDeleteByPrice,
                new MapSqlParameterSource("price", price));
    }

    public void update(Order order) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice())
                        .addValue("orderId", order.getId()));

    }

    public Order loadById(long orderId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("orderId", orderId),
                new OrderRowMapper());
    }

    public List<Order> loadAll() {
        return namedParameterJdbcTemplate.query(
                sqlLoadAll,
                new OrderRowMapper());
    }

    public List<Order> loadByCustomerId(long customerId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCustomerId,
                new MapSqlParameterSource("customerId", customerId),
                new OrderRowMapper());
    }
}
