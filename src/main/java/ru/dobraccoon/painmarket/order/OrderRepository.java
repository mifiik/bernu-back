package ru.dobraccoon.painmarket.order;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public OrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");
    }

    public void create(Order order) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice())
        );
    }

    public void deleteById(long id) {
        String sqlDeleteById = "DELETE FROM orders WHERE id = :id;";
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("id", id));
    }

    public void deleteByCustomerId(long customerId) {
        String sqlDeleteByCustomerId = "DELETE FROM orders WHERE customer_id = :customerId";
        namedParameterJdbcTemplate.update(
                sqlDeleteByCustomerId,
                new MapSqlParameterSource("customerId", customerId));
    }

    public void deleteByPrice(long price) {
        String sqlDeleteByPrice = "DELETE FROM orders WHERE price = :price;";
        namedParameterJdbcTemplate.update(
                sqlDeleteByPrice,
                new MapSqlParameterSource("price", price));
    }

    public void update(Order order) {
        String sqlUpdate = "UPDATE orders SET product_id = :productId, customer_id = :customerId, price = :price " +
                " WHERE id = :orderId";

        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice())
                        .addValue("orderId", order.getId())
        );

    }

    public Order loadById(long orderId) {
        String sqlLoadById = "SELECT * FROM orders WHERE id = :orderId";

        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("orderId", orderId),
                new OrderRowMapper());
    }

    public List<Order> loadAll() {
        String sqlLoadAll = "SELECT * FROM orders;";

        return namedParameterJdbcTemplate.query(sqlLoadAll, new OrderRowMapper());
    }

    public List<Order> loadByCustomerId(long customerId) {
        String sqlLoadByCustomerId = "SELECT * FROM orders WHERE customer_id = :customerId";

        return namedParameterJdbcTemplate.query(
                sqlLoadByCustomerId,
                new MapSqlParameterSource("customerId", customerId),
                new OrderRowMapper());
    }
}
