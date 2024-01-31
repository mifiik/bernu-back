package ru.dobraccoon.painmarket.order;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlDeleteById = "DELETE FROM orders WHERE id = :id;";
    private static final String sqlDeleteByCustomerId = "DELETE FROM orders WHERE customer_id = :customerId";
    private static final String sqlDeleteByPrice = "DELETE FROM orders WHERE price = :price;";
    private static final String sqlLoadById = "SELECT * FROM orders WHERE id = :orderId";
    private static final String sqlLoadAll = "SELECT * FROM orders;";

    private static final String sqlLoadByCustomerId = "SELECT * FROM orders WHERE customer_id = :customerId";

    public OrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");
    }

    public void create(Order order) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice())
        );
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

    public Order loadById(long orderId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("orderId", orderId),
                new OrderRowMapper());
    }

    public List<Order> loadAll() {
        return namedParameterJdbcTemplate.query(sqlLoadAll, new OrderRowMapper());
    }

    public List<Order> loadByCustomerId(long customerId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCustomerId,
                new MapSqlParameterSource("customerId", customerId),
                new OrderRowMapper());
    }
}
